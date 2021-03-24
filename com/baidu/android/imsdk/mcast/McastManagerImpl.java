package com.baidu.android.imsdk.mcast;

import android.content.Context;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
/* loaded from: classes2.dex */
public class McastManagerImpl {
    public static volatile McastManagerImpl mInstance;
    public Context mContext;

    public McastManagerImpl(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static McastManagerImpl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (McastManagerImpl.class) {
                if (mInstance == null) {
                    mInstance = new McastManagerImpl(context);
                }
            }
        }
        return mInstance;
    }

    public String getAllCastIdList() {
        return ConversationStudioManImpl.getInstance(this.mContext).getAllCastIdList();
    }

    public long getJoinedCastId() {
        return ConversationStudioManImpl.getInstance(this.mContext).getJoinedCastId();
    }

    public long getMaxReliableMsgId(long j) {
        return ConversationStudioManImpl.getInstance(this.mContext).getMaxReliableMsgId(j);
    }

    public long getReliableMsgCount(long j) {
        return ConversationStudioManImpl.getInstance(this.mContext).getReliableMsgCount(j);
    }

    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
    }
}
