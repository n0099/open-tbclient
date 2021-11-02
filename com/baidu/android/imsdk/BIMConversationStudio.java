package com.baidu.android.imsdk;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.CastServiceFactory;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.mcast.UnLoginCastService;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BIMConversationStudio extends BIMConversation {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "BIMConversationStudio";
    public transient /* synthetic */ FieldHolder $fh;
    public String mCastId;
    public IMcastSetListener mCastListener;
    public UnLoginCastService mCastService;
    public int mCastType;
    public String mCastUrl;
    public boolean mIsReliable;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1411740253, "Lcom/baidu/android/imsdk/BIMConversationStudio;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1411740253, "Lcom/baidu/android/imsdk/BIMConversationStudio;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BIMConversationStudio(Context context, BIMManager.CATEGORY category, String str, boolean z, ChatSession chatSession, String str2, int i2) {
        super(context, category, str, chatSession, str2, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, category, str, Boolean.valueOf(z), chatSession, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BIMManager.CATEGORY) objArr2[1], (String) objArr2[2], (ChatSession) objArr2[3], (String) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCastUrl = null;
        this.mCastId = "";
        this.mIsReliable = false;
        this.mCastService = null;
        this.mCastUrl = str2;
        this.mCastType = i2;
        this.mCastId = str;
        this.mIsReliable = z;
    }

    private void beginOtherCastType(IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, iMcastSetListener) == null) {
            UnLoginCastService unLoginCastService = this.mCastService;
            if (unLoginCastService != null) {
                unLoginCastService.stopService(0);
                LogUtils.d(TAG, "stop service before start as service is not null.");
            }
            UnLoginCastService createCastService = CastServiceFactory.createCastService(this.mContext);
            this.mCastService = createCastService;
            try {
                iMcastSetListener.onResult(createCastService.startService(this.mCastId, this.mCastUrl, this.mCastType), this.session.getContacter(), -1L);
            } catch (Exception e2) {
                LogUtils.e(TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void beginWithCompletion(IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iMcastSetListener) == null) {
            this.mCastListener = iMcastSetListener;
            beginWithCompletion(Long.parseLong(this.mCastId), this.mIsReliable, iMcastSetListener);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void endWithCompletion(IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMcastSetListener) == null) {
            if (this.mCastType == 2) {
                ConversationStudioManImpl.getInstance(this.mContext).endWithCompletion(this.session.getContacter(), iMcastSetListener);
            } else {
                UnLoginCastService unLoginCastService = this.mCastService;
                if (unLoginCastService != null) {
                    unLoginCastService.stopService(0);
                }
                iMcastSetListener.onResult(0, this.session.getContacter(), -1L);
            }
            try {
                unregisterLiveMsgReceiveListener(Long.valueOf(this.mCastId).longValue());
            } catch (NumberFormatException e2) {
                LogUtils.e(TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void pauseCastMessage() {
        UnLoginCastService unLoginCastService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (unLoginCastService = this.mCastService) == null) {
            return;
        }
        unLoginCastService.pause();
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void playCastMessage() {
        UnLoginCastService unLoginCastService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (unLoginCastService = this.mCastService) == null) {
            return;
        }
        unLoginCastService.replay(this.mCastId, this.mCastUrl, this.mCastType);
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void seekCastMessage(int i2) {
        UnLoginCastService unLoginCastService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (unLoginCastService = this.mCastService) == null) {
            return;
        }
        unLoginCastService.seek(i2);
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void sendQuizOpts(long j, long j2, int i2, String str, IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), str, iMcastSetListener}) == null) {
            if (this.mCastType == 2) {
                ConversationStudioManImpl.getInstance(this.mContext).sendQuizOpts(j, j2, i2, str, iMcastSetListener);
                return;
            }
            UnLoginCastService unLoginCastService = this.mCastService;
            if (unLoginCastService != null) {
                unLoginCastService.stopService(0);
            }
            iMcastSetListener.onResult(0, this.session.getContacter(), -1L);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void setPullInterval(int i2) {
        UnLoginCastService unLoginCastService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (unLoginCastService = this.mCastService) == null) {
            return;
        }
        unLoginCastService.setPullInterval(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginWithCompletion(long j, boolean z, IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), iMcastSetListener}) == null) {
            this.mCastListener = iMcastSetListener;
            if (this.mCastType == 2) {
                ConversationStudioManImpl.getInstance(this.mContext).beginWithCompletion(j, z, new IMcastSetListener(this, j, z) { // from class: com.baidu.android.imsdk.BIMConversationStudio.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BIMConversationStudio this$0;
                    public final /* synthetic */ long val$castId;
                    public final /* synthetic */ boolean val$isReliable;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j), Boolean.valueOf(z)};
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
                        this.val$castId = j;
                        this.val$isReliable = z;
                    }

                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                    public void onResult(int i2, long j2, long j3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                            if (i2 == 1316) {
                                this.this$0.mCastType = 0;
                                BIMConversationStudio bIMConversationStudio = this.this$0;
                                bIMConversationStudio.beginWithCompletion(this.val$castId, this.val$isReliable, bIMConversationStudio.mCastListener);
                            }
                            if (this.this$0.mCastListener != null) {
                                this.this$0.mCastListener.onResult(i2, j2, j3);
                            }
                        }
                    }
                });
            } else {
                beginOtherCastType(iMcastSetListener);
            }
        }
    }
}
