package com.baidu.android.imsdk.upload;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener;
import com.baidu.android.imsdk.chatmessage.messages.AudioMsg;
import com.baidu.android.imsdk.chatmessage.messages.AudioTextMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.DuzhanUpMsgCreator;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.Base64;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class AsyncChatTask implements IUploadTransferListener, IGenBosObjectUrlListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FORMAT_AAC = 2;
    public static final int FORMAT_AMR = 1;
    public static final int FORMAT_MP3 = 0;
    public static final int FORMAT_MP4 = 0;
    public static final String GET_URL = "get_url";
    public static final String PUT_URL = "put_url";
    public static final String TAG = "AsyncChatTask";
    public static final String THUMB_URL = "thumb_url";
    public transient /* synthetic */ FieldHolder $fh;
    public String mContentType;
    public Context mContext;
    public String mFilePath;
    public String mGetUrl;
    public ChatMsg mMsg;
    public IUploadTransferListener mMsgListener;
    public String mPutUrl;
    public String mThumbUrl;
    public int mType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(925083529, "Lcom/baidu/android/imsdk/upload/AsyncChatTask;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(925083529, "Lcom/baidu/android/imsdk/upload/AsyncChatTask;");
        }
    }

    public AsyncChatTask(Context context, ChatMsg chatMsg, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatMsg, iUploadTransferListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFilePath = null;
        this.mType = 0;
        this.mContext = context;
        this.mMsg = chatMsg;
        this.mType = chatMsg.getMsgType();
        this.mFilePath = this.mMsg.getLocalUrl();
        this.mMsgListener = iUploadTransferListener;
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onProgress(int i) {
        IUploadTransferListener iUploadTransferListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (iUploadTransferListener = this.mMsgListener) != null) {
            iUploadTransferListener.onProgress(i);
        }
    }

    public void execute() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            int chatType = this.mMsg.getChatType();
            if (file.exists()) {
                int i = this.mType;
                if (i == 1) {
                    this.mContentType = WordCommandManager.IMAGE_JPEG;
                    try {
                        str = this.mFilePath.substring(this.mFilePath.lastIndexOf(".") + 1);
                    } catch (Exception e) {
                        LogUtils.e(TAG, e.getMessage());
                        str = "";
                    }
                    ChatMsgManager.genBosObjectUrl(this.mContext, this.mFilePath, this.mContentType, str, DuzhanUpMsgCreator.getReqType(chatType), 0, 0, this);
                    return;
                } else if (i == 2 || i == 82) {
                    this.mContentType = "audio/amr";
                    ChatMsgManager.audioTrans(this.mContext, this.mFilePath, "audio/amr", "amr", DuzhanUpMsgCreator.getReqType(chatType), new BIMValueCallBack(this, chatType) { // from class: com.baidu.android.imsdk.upload.AsyncChatTask.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AsyncChatTask this$0;
                        public final /* synthetic */ int val$chatType;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(chatType)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$chatType = chatType;
                        }

                        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0091 */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Removed duplicated region for block: B:43:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        /* JADX WARN: Type inference failed for: r0v14 */
                        /* JADX WARN: Type inference failed for: r0v15 */
                        /* JADX WARN: Type inference failed for: r0v2 */
                        /* JADX WARN: Type inference failed for: r0v5 */
                        /* JADX WARN: Type inference failed for: r0v7, types: [java.io.FileOutputStream] */
                        @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void onResult(int i2, String str3, Object obj) {
                            Throwable th;
                            FileOutputStream fileOutputStream;
                            Exception e2;
                            Interceptable interceptable2 = $ic;
                            ?? r0 = interceptable2;
                            if (interceptable2 != null) {
                                InterceptResult invokeILL = interceptable2.invokeILL(1048576, this, i2, str3, obj);
                                r0 = invokeILL;
                                if (invokeILL != null) {
                                    return;
                                }
                            }
                            if (i2 == 0) {
                                FileOutputStream fileOutputStream2 = null;
                                try {
                                    try {
                                        try {
                                            byte[] decode = Base64.decode((String) obj);
                                            File file2 = new File(this.this$0.mFilePath);
                                            if (file2.exists()) {
                                                fileOutputStream = new FileOutputStream(file2);
                                                try {
                                                    fileOutputStream.write(decode);
                                                    fileOutputStream.flush();
                                                    fileOutputStream2 = fileOutputStream;
                                                } catch (Exception e3) {
                                                    e2 = e3;
                                                    this.this$0.onGenBosObjectUrlListener(1023, Constants.ERROR_MSG_HTTP_RESPONSE_ERROR, null, null, null);
                                                    LogUtils.e(AsyncChatTask.TAG, e2.getMessage());
                                                    if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                    ChatMsgManager.genBosObjectUrl(this.this$0.mContext, this.this$0.mFilePath, this.this$0.mContentType, "amr", DuzhanUpMsgCreator.getReqType(this.val$chatType), 0, 0, this.this$0);
                                                    return;
                                                }
                                            } else {
                                                this.this$0.onGenBosObjectUrlListener(1007, Constants.ERROR_MSG_PARAMETER_ERROR, null, null, null);
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (r0 != 0) {
                                                try {
                                                    r0.close();
                                                } catch (Exception e4) {
                                                    LogUtils.e(AsyncChatTask.TAG, e4.getMessage());
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e5) {
                                        fileOutputStream = null;
                                        e2 = e5;
                                    } catch (Throwable th3) {
                                        r0 = 0;
                                        th = th3;
                                        if (r0 != 0) {
                                        }
                                        throw th;
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                } catch (Exception e6) {
                                    LogUtils.e(AsyncChatTask.TAG, e6.getMessage());
                                }
                                ChatMsgManager.genBosObjectUrl(this.this$0.mContext, this.this$0.mFilePath, this.this$0.mContentType, "amr", DuzhanUpMsgCreator.getReqType(this.val$chatType), 0, 0, this.this$0);
                                return;
                            }
                            this.this$0.onGenBosObjectUrlListener(1018, Constants.ERROR_MSG_HTTP_RESPONSE_ERROR, null, null, null);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            IUploadTransferListener iUploadTransferListener2 = this.mMsgListener;
            if (iUploadTransferListener2 != null) {
                iUploadTransferListener2.onFailed(1007, this.mType, this.mFilePath);
            }
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onFailed(int i, int i2, String str) {
        IUploadTransferListener iUploadTransferListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) && (iUploadTransferListener = this.mMsgListener) != null) {
            iUploadTransferListener.onFailed(i, this.mType, this.mFilePath);
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onFinished(int i, String str) {
        IUploadTransferListener iUploadTransferListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) && (iUploadTransferListener = this.mMsgListener) != null) {
            iUploadTransferListener.onFinished(i, this.mGetUrl);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
    public void onGenBosObjectUrlListener(int i, String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, str2, str3, map}) == null) {
            onGenBosObjectUrlListener(i, str2, str3, map);
        }
    }

    public void onGenBosObjectUrlListener(int i, String str, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, str2, map}) == null) {
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
                } else if (i2 == 82) {
                    ChatMsg chatMsg2 = this.mMsg;
                    ((AudioTextMsg) chatMsg2).setContent(this.mGetUrl, 1, ((AudioTextMsg) chatMsg2).getDuration(), ((AudioTextMsg) this.mMsg).getText());
                    ((AudioTextMsg) this.mMsg).setRemoteUrl(this.mGetUrl);
                }
                new AsyncUploadTask(this.mContext, this.mType, this.mPutUrl, this.mFilePath, this.mContentType, str, str2, this).execute(new Void[0]);
                return;
            }
            IUploadTransferListener iUploadTransferListener = this.mMsgListener;
            if (iUploadTransferListener != null) {
                iUploadTransferListener.onFailed(i, this.mType, this.mFilePath);
            }
        }
    }
}
