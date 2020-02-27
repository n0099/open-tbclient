package com.baidu.android.imsdk.upload;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.ResponseCode;
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
import com.baidu.android.util.media.MimeType;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
/* loaded from: classes3.dex */
public class AsyncChatTask implements IGenBosObjectUrlListener, IUploadTransferListener {
    public static final int FORMAT_AAC = 2;
    public static final int FORMAT_AMR = 1;
    public static final int FORMAT_MP3 = 0;
    public static final int FORMAT_MP4 = 0;
    public static final String GET_URL = "get_url";
    public static final String PUT_URL = "put_url";
    private static final String TAG = AsyncChatTask.class.getSimpleName();
    public static final String THUMB_URL = "thumb_url";
    private String mContentType;
    private Context mContext;
    private String mFilePath;
    private String mGetUrl;
    private ChatMsg mMsg;
    private IUploadTransferListener mMsgListener;
    private String mPutUrl;
    private String mThumbUrl;
    private int mType;

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
        if (this.mFilePath == null && this.mMsgListener != null) {
            this.mMsgListener.onFailed(1007, this.mType, this.mFilePath);
        }
        File file = new File(this.mFilePath);
        final int chatType = this.mMsg.getChatType();
        if (file != null && file.exists()) {
            if (this.mType == 1) {
                this.mContentType = MimeType.Image.JPEG;
                String str = "";
                try {
                    str = this.mFilePath.substring(this.mFilePath.lastIndexOf(".") + 1);
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, e.getMessage());
                }
                ChatMsgManager.genBosObjectUrl(this.mContext, this.mFilePath, this.mContentType, str, DuzhanUpMsgCreator.getReqType(chatType), 0, 0, this);
            } else if (this.mType == 2) {
                this.mContentType = MimeType.Audio.AMR;
                ChatMsgManager.audioTrans(this.mContext, this.mFilePath, this.mContentType, "amr", DuzhanUpMsgCreator.getReqType(chatType), new BIMValueCallBack() { // from class: com.baidu.android.imsdk.upload.AsyncChatTask.1
                    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [112=6, 113=6] */
                    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onResult(int i, String str2, Object obj) {
                        FileOutputStream fileOutputStream;
                        Exception exc;
                        FileOutputStream fileOutputStream2;
                        if (i != 0) {
                            AsyncChatTask.this.onGenBosObjectUrlListener(1018, Constants.ERROR_MSG_HTTP_RESPONSE_ERROR, null, null, null);
                            return;
                        }
                        try {
                            byte[] decode = Base64.decode((String) obj);
                            File file2 = new File(AsyncChatTask.this.mFilePath);
                            if (file2.exists()) {
                                fileOutputStream2 = new FileOutputStream(file2);
                                try {
                                    fileOutputStream2.write(decode);
                                    fileOutputStream2.flush();
                                } catch (Exception e2) {
                                    exc = e2;
                                    fileOutputStream = fileOutputStream2;
                                    try {
                                        new IMTrack.CrashBuilder(AsyncChatTask.this.mContext).exception(Log.getStackTraceString(exc)).build();
                                        AsyncChatTask.this.onGenBosObjectUrlListener(ResponseCode.PROTOCOL_EXP, Constants.ERROR_MSG_HTTP_RESPONSE_ERROR, null, null, null);
                                        LogUtils.e(AsyncChatTask.TAG, exc.getMessage());
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (Exception e3) {
                                                new IMTrack.CrashBuilder(AsyncChatTask.this.mContext).exception(Log.getStackTraceString(e3)).build();
                                                LogUtils.e(AsyncChatTask.TAG, e3.getMessage());
                                            }
                                        }
                                        ChatMsgManager.genBosObjectUrl(AsyncChatTask.this.mContext, AsyncChatTask.this.mFilePath, AsyncChatTask.this.mContentType, "amr", DuzhanUpMsgCreator.getReqType(chatType), 0, 0, AsyncChatTask.this);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (Exception e4) {
                                                new IMTrack.CrashBuilder(AsyncChatTask.this.mContext).exception(Log.getStackTraceString(e4)).build();
                                                LogUtils.e(AsyncChatTask.TAG, e4.getMessage());
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                AsyncChatTask.this.onGenBosObjectUrlListener(1007, Constants.ERROR_MSG_PARAMETER_ERROR, null, null, null);
                                fileOutputStream2 = null;
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Exception e5) {
                                    new IMTrack.CrashBuilder(AsyncChatTask.this.mContext).exception(Log.getStackTraceString(e5)).build();
                                    LogUtils.e(AsyncChatTask.TAG, e5.getMessage());
                                }
                            }
                        } catch (Exception e6) {
                            fileOutputStream = null;
                            exc = e6;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                        ChatMsgManager.genBosObjectUrl(AsyncChatTask.this.mContext, AsyncChatTask.this.mFilePath, AsyncChatTask.this.mContentType, "amr", DuzhanUpMsgCreator.getReqType(chatType), 0, 0, AsyncChatTask.this);
                    }
                });
            }
        } else if (this.mMsgListener != null) {
            this.mMsgListener.onFailed(1007, this.mType, this.mFilePath);
        }
    }

    public void onGenBosObjectUrlListener(int i, String str, String str2, Map<String, String> map) {
        if (i == 0) {
            this.mGetUrl = map.get(GET_URL);
            this.mPutUrl = map.get(PUT_URL);
            this.mThumbUrl = map.get(THUMB_URL);
            LogUtils.i(TAG, "get_url:" + this.mGetUrl);
            LogUtils.i(TAG, "put_url:" + this.mPutUrl);
            LogUtils.i(TAG, "authorication:" + str);
            LogUtils.i(TAG, "xBceData:" + str2);
            if (this.mType == 1) {
                ((ImageMsg) this.mMsg).setRemoteUrl(this.mGetUrl);
                ((ImageMsg) this.mMsg).setThumbUrl(this.mThumbUrl);
                ((ImageMsg) this.mMsg).setContent(this.mGetUrl);
            } else if (this.mType == 2) {
                ((AudioMsg) this.mMsg).setContent(this.mGetUrl, 1, ((AudioMsg) this.mMsg).getDuration());
                ((AudioMsg) this.mMsg).setRemoteUrl(this.mGetUrl);
            }
            new AsyncUploadTask(this.mContext, this.mType, this.mPutUrl, this.mFilePath, this.mContentType, str, str2, this).execute(new Void[0]);
        } else if (this.mMsgListener != null) {
            this.mMsgListener.onFailed(i, this.mType, this.mFilePath);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
    public void onGenBosObjectUrlListener(int i, String str, String str2, String str3, Map<String, String> map) {
        onGenBosObjectUrlListener(i, str2, str3, map);
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onFailed(int i, int i2, String str) {
        if (this.mMsgListener != null) {
            this.mMsgListener.onFailed(i, this.mType, this.mFilePath);
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onFinished(int i, String str) {
        if (this.mMsgListener != null) {
            this.mMsgListener.onFinished(i, this.mGetUrl);
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onProgress(int i) {
        if (this.mMsgListener != null) {
            this.mMsgListener.onProgress(i);
        }
    }
}
