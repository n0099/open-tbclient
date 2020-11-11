package com.baidu.android.imsdk;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.mcast.CastServiceFactory;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.mcast.UnLoginCastService;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes18.dex */
public class BIMConversationStudio extends BIMConversation {
    private static String TAG = "BIMConversationStudio";
    private String mCastId;
    private IMcastSetListener mCastListener;
    private UnLoginCastService mCastService;
    private int mCastType;
    private String mCastUrl;
    private boolean mIsReliable;

    public BIMConversationStudio(Context context, BIMManager.CATEGORY category, String str, boolean z, ChatSession chatSession, String str2, int i) {
        super(context, category, str, chatSession, str2, i);
        this.mCastUrl = null;
        this.mCastId = "";
        this.mIsReliable = false;
        this.mCastService = null;
        this.mCastUrl = str2;
        this.mCastType = i;
        this.mCastId = str;
        this.mIsReliable = z;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void beginWithCompletion(IMcastSetListener iMcastSetListener) {
        this.mCastListener = iMcastSetListener;
        beginWithCompletion(Long.parseLong(this.mCastId), this.mIsReliable, iMcastSetListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginWithCompletion(final long j, final boolean z, IMcastSetListener iMcastSetListener) {
        this.mCastListener = iMcastSetListener;
        if (this.mCastType == 2) {
            ConversationStudioManImpl.getInstance(this.mContext).beginWithCompletion(j, z, new IMcastSetListener() { // from class: com.baidu.android.imsdk.BIMConversationStudio.1
                @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                public void onResult(int i, long j2, long j3) {
                    if (i == 1316) {
                        BIMConversationStudio.this.mCastType = 0;
                        BIMConversationStudio.this.beginWithCompletion(j, z, BIMConversationStudio.this.mCastListener);
                    }
                    if (BIMConversationStudio.this.mCastListener != null) {
                        BIMConversationStudio.this.mCastListener.onResult(i, j2, j3);
                    }
                }
            });
        } else {
            beginOtherCastType(iMcastSetListener);
        }
    }

    private void beginOtherCastType(IMcastSetListener iMcastSetListener) {
        if (this.mCastService != null) {
            this.mCastService.stopService(0);
            LogUtils.d(TAG, "stop service before start as service is not null.");
        }
        this.mCastService = CastServiceFactory.createCastService(this.mContext);
        try {
            iMcastSetListener.onResult(this.mCastService.startService(this.mCastId, this.mCastUrl, this.mCastType), this.session.getContacter(), -1L);
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void setPullInterval(int i) {
        if (this.mCastService != null) {
            this.mCastService.setPullInterval(i);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void endWithCompletion(IMcastSetListener iMcastSetListener) {
        if (this.mCastType == 2) {
            ConversationStudioManImpl.getInstance(this.mContext).endWithCompletion(this.session.getContacter(), iMcastSetListener);
        } else {
            if (this.mCastService != null) {
                this.mCastService.stopService(0);
            }
            iMcastSetListener.onResult(0, this.session.getContacter(), -1L);
        }
        try {
            unregisterLiveMsgReceiveListener(Long.valueOf(this.mCastId).longValue());
        } catch (NumberFormatException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void playCastMessage() {
        if (this.mCastService != null) {
            this.mCastService.replay(this.mCastId, this.mCastUrl, this.mCastType);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void pauseCastMessage() {
        if (this.mCastService != null) {
            this.mCastService.pause();
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void seekCastMessage(int i) {
        if (this.mCastService != null) {
            this.mCastService.seek(i);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
        if (this.mCastType == 2) {
            ConversationStudioManImpl.getInstance(this.mContext).sendQuizOpts(j, j2, i, str, iMcastSetListener);
            return;
        }
        if (this.mCastService != null) {
            this.mCastService.stopService(0);
        }
        iMcastSetListener.onResult(0, this.session.getContacter(), -1L);
    }
}
