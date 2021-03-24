package com.baidu.android.imsdk.upload;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener;
import com.baidu.android.imsdk.chatmessage.messages.AudioMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.DuzhanUpMsgCreator;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.Base64;
import com.baidu.android.imsdk.utils.LogUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
/* loaded from: classes2.dex */
public class AsyncChatTask implements IUploadTransferListener, IGenBosObjectUrlListener {
    public static final int FORMAT_AAC = 2;
    public static final int FORMAT_AMR = 1;
    public static final int FORMAT_MP3 = 0;
    public static final int FORMAT_MP4 = 0;
    public static final String GET_URL = "get_url";
    public static final String PUT_URL = "put_url";
    public static final String TAG = "AsyncChatTask";
    public static final String THUMB_URL = "thumb_url";
    public String mContentType;
    public Context mContext;
    public String mFilePath;
    public String mGetUrl;
    public ChatMsg mMsg;
    public IUploadTransferListener mMsgListener;
    public String mPutUrl;
    public String mThumbUrl;
    public int mType;

    public AsyncChatTask(Context context, ChatMsg chatMsg, IUploadTransferListener iUploadTransferListener) {
        this.mFilePath = null;
        this.mType = 0;
        this.mContext = context;
        this.mMsg = chatMsg;
        this.mType = chatMsg.getMsgType();
        this.mFilePath = this.mMsg.getLocalUrl();
        this.mMsgListener = iUploadTransferListener;
    }

    public void execute() {
        String str;
        String str2 = this.mFilePath;
        if (str2 == null) {
            IUploadTransferListener iUploadTransferListener = this.mMsgListener;
            if (iUploadTransferListener != null) {
                iUploadTransferListener.onFailed(1007, this.mType, str2);
                return;
            }
            return;
        }
        File file = new File(this.mFilePath);
        final int chatType = this.mMsg.getChatType();
        if (file.exists()) {
            int i = this.mType;
            if (i != 1) {
                if (i == 2) {
                    this.mContentType = "audio/amr";
                    ChatMsgManager.audioTrans(this.mContext, this.mFilePath, "audio/amr", "amr", DuzhanUpMsgCreator.getReqType(chatType), new BIMValueCallBack() { // from class: com.baidu.android.imsdk.upload.AsyncChatTask.1
                        /* JADX WARN: Removed duplicated region for block: B:38:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void onResult(int i2, String str3, Object obj) {
                            Throwable th;
                            FileOutputStream fileOutputStream;
                            Exception e2;
                            IMTrack.CrashBuilder crashBuilder;
                            if (i2 == 0) {
                                FileOutputStream fileOutputStream2 = null;
                                try {
                                    try {
                                        byte[] decode = Base64.decode((String) obj);
                                        File file2 = new File(AsyncChatTask.this.mFilePath);
                                        if (file2.exists()) {
                                            fileOutputStream = new FileOutputStream(file2);
                                            try {
                                                fileOutputStream.write(decode);
                                                fileOutputStream.flush();
                                                fileOutputStream2 = fileOutputStream;
                                            } catch (Exception e3) {
                                                e2 = e3;
                                                new IMTrack.CrashBuilder(AsyncChatTask.this.mContext).exception(Log.getStackTraceString(e2)).build();
                                                AsyncChatTask.this.onGenBosObjectUrlListener(1023, Constants.ERROR_MSG_HTTP_RESPONSE_ERROR, null, null, null);
                                                LogUtils.e(AsyncChatTask.TAG, e2.getMessage());
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        crashBuilder = new IMTrack.CrashBuilder(AsyncChatTask.this.mContext);
                                                        crashBuilder.exception(Log.getStackTraceString(e)).build();
                                                        LogUtils.e(AsyncChatTask.TAG, e.getMessage());
                                                        ChatMsgManager.genBosObjectUrl(AsyncChatTask.this.mContext, AsyncChatTask.this.mFilePath, AsyncChatTask.this.mContentType, "amr", DuzhanUpMsgCreator.getReqType(chatType), 0, 0, AsyncChatTask.this);
                                                        return;
                                                    }
                                                }
                                                ChatMsgManager.genBosObjectUrl(AsyncChatTask.this.mContext, AsyncChatTask.this.mFilePath, AsyncChatTask.this.mContentType, "amr", DuzhanUpMsgCreator.getReqType(chatType), 0, 0, AsyncChatTask.this);
                                                return;
                                            }
                                        } else {
                                            AsyncChatTask.this.onGenBosObjectUrlListener(1007, Constants.ERROR_MSG_PARAMETER_ERROR, null, null, null);
                                        }
                                        if (fileOutputStream2 != null) {
                                            try {
                                                fileOutputStream2.close();
                                            } catch (Exception e5) {
                                                e = e5;
                                                crashBuilder = new IMTrack.CrashBuilder(AsyncChatTask.this.mContext);
                                                crashBuilder.exception(Log.getStackTraceString(e)).build();
                                                LogUtils.e(AsyncChatTask.TAG, e.getMessage());
                                                ChatMsgManager.genBosObjectUrl(AsyncChatTask.this.mContext, AsyncChatTask.this.mFilePath, AsyncChatTask.this.mContentType, "amr", DuzhanUpMsgCreator.getReqType(chatType), 0, 0, AsyncChatTask.this);
                                                return;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (0 != 0) {
                                            try {
                                                fileOutputStream2.close();
                                            } catch (Exception e6) {
                                                new IMTrack.CrashBuilder(AsyncChatTask.this.mContext).exception(Log.getStackTraceString(e6)).build();
                                                LogUtils.e(AsyncChatTask.TAG, e6.getMessage());
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Exception e7) {
                                    fileOutputStream = null;
                                    e2 = e7;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (0 != 0) {
                                    }
                                    throw th;
                                }
                                ChatMsgManager.genBosObjectUrl(AsyncChatTask.this.mContext, AsyncChatTask.this.mFilePath, AsyncChatTask.this.mContentType, "amr", DuzhanUpMsgCreator.getReqType(chatType), 0, 0, AsyncChatTask.this);
                                return;
                            }
                            AsyncChatTask.this.onGenBosObjectUrlListener(1018, Constants.ERROR_MSG_HTTP_RESPONSE_ERROR, null, null, null);
                        }
                    });
                    return;
                }
                return;
            }
            this.mContentType = "image/jpeg";
            try {
                str = this.mFilePath.substring(this.mFilePath.lastIndexOf(".") + 1);
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, e2.getMessage());
                str = "";
            }
            ChatMsgManager.genBosObjectUrl(this.mContext, this.mFilePath, this.mContentType, str, DuzhanUpMsgCreator.getReqType(chatType), 0, 0, this);
            return;
        }
        IUploadTransferListener iUploadTransferListener2 = this.mMsgListener;
        if (iUploadTransferListener2 != null) {
            iUploadTransferListener2.onFailed(1007, this.mType, this.mFilePath);
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onFailed(int i, int i2, String str) {
        IUploadTransferListener iUploadTransferListener = this.mMsgListener;
        if (iUploadTransferListener != null) {
            iUploadTransferListener.onFailed(i, this.mType, this.mFilePath);
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onFinished(int i, String str) {
        IUploadTransferListener iUploadTransferListener = this.mMsgListener;
        if (iUploadTransferListener != null) {
            iUploadTransferListener.onFinished(i, this.mGetUrl);
        }
    }

    public void onGenBosObjectUrlListener(int i, String str, String str2, Map<String, String> map) {
        if (i == 0) {
            this.mGetUrl = map.get(GET_URL);
            this.mPutUrl = map.get(PUT_URL);
            this.mThumbUrl = map.get("thumb_url");
            String str3 = TAG;
            LogUtils.i(str3, "get_url:" + this.mGetUrl);
            String str4 = TAG;
            LogUtils.i(str4, "put_url:" + this.mPutUrl);
            String str5 = TAG;
            LogUtils.i(str5, "authorication:" + str);
            String str6 = TAG;
            LogUtils.i(str6, "xBceData:" + str2);
            int i2 = this.mType;
            if (i2 == 1) {
                ((ImageMsg) this.mMsg).setRemoteUrl(this.mGetUrl);
                ((ImageMsg) this.mMsg).setThumbUrl(this.mThumbUrl);
                ((ImageMsg) this.mMsg).setContent(this.mGetUrl);
            } else if (i2 == 2) {
                ChatMsg chatMsg = this.mMsg;
                ((AudioMsg) chatMsg).setContent(this.mGetUrl, 1, ((AudioMsg) chatMsg).getDuration());
                ((AudioMsg) this.mMsg).setRemoteUrl(this.mGetUrl);
            }
            new AsyncUploadTask(this.mContext, this.mType, this.mPutUrl, this.mFilePath, this.mContentType, str, str2, this).execute(new Void[0]);
            return;
        }
        IUploadTransferListener iUploadTransferListener = this.mMsgListener;
        if (iUploadTransferListener != null) {
            iUploadTransferListener.onFailed(i, this.mType, this.mFilePath);
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onProgress(int i) {
        IUploadTransferListener iUploadTransferListener = this.mMsgListener;
        if (iUploadTransferListener != null) {
            iUploadTransferListener.onProgress(i);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
    public void onGenBosObjectUrlListener(int i, String str, String str2, String str3, Map<String, String> map) {
        onGenBosObjectUrlListener(i, str2, str3, map);
    }
}
