package com.baidu.sapi2.views.logindialog.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes2.dex */
public class ShareLoginView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String j = "quick_login";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Activity b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ShareStorage.StorageModel h;
    public ILoginConfirmCallback i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareLoginView a;

        /* renamed from: com.baidu.sapi2.views.logindialog.view.ShareLoginView$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0140a extends WebAuthListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ a b;

            public C0140a(a aVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                    if (this.b.a.i == null) {
                        Log.e(QuickLoginDialog.STAG, "sharelogin mWebAuthListener is null");
                        return;
                    }
                    com.baidu.sapi2.views.logindialog.utils.a.a("share_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                    QuickLoginResult quickLoginResult = new QuickLoginResult();
                    quickLoginResult.setResultCode(webAuthResult.getResultCode());
                    quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                    quickLoginResult.mLoginType = QuickLoginType.SHARE;
                    this.b.a.i.onFailure(quickLoginResult);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                    if (this.b.a.i == null) {
                        Log.e(QuickLoginDialog.STAG, "sharelogin mWebAuthListener is null");
                        return;
                    }
                    com.baidu.sapi2.views.logindialog.utils.a.a("share_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                    QuickLoginResult quickLoginResult = new QuickLoginResult();
                    quickLoginResult.setResultCode(webAuthResult.getResultCode());
                    quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                    quickLoginResult.mLoginType = QuickLoginType.SHARE;
                    this.b.a.i.onSuccess(quickLoginResult);
                }
            }
        }

        public a(ShareLoginView shareLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareLoginView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null) {
                    if (this.a.h != null) {
                        if (this.a.i != null) {
                            if (!this.a.i.onPreStart(false)) {
                                Log.e(QuickLoginDialog.STAG, "sharelogin privacy is not agree");
                                return;
                            }
                            CoreViewRouter.getInstance().invokeV2ShareLogin(this.a.b, this.a.h, new C0140a(this, System.currentTimeMillis()), "quick_login");
                            return;
                        }
                        Log.e(QuickLoginDialog.STAG, "sharelogin mWebAuthListener is null");
                        return;
                    }
                    Log.e(QuickLoginDialog.STAG, "sharelogin mShareModel is null");
                    return;
                }
                Log.e(QuickLoginDialog.STAG, "sharelogin mActivity is null");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements AsyncImageLoader.IAsyncImageLoaderListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareLoginView a;

        public b(ShareLoginView shareLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareLoginView;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
        public void onComplete(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                this.a.d.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareLoginView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public TextView getTvButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareLoginView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04c6, this);
            this.c = findViewById(R.id.obfuscated_res_0x7f091d52);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cc7);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091cc6);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091cc8);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091d4d);
            a aVar = new a(this);
            this.c.setOnClickListener(aVar);
            this.g.setOnClickListener(aVar);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.h == null || this.a == null) {
            return;
        }
        ImageManager.getInstance().loadImage(this.a, Uri.parse(this.h.url), new b(this));
        this.e.setText(this.h.displayname);
        this.f.setText(MessageFormat.format("{0}使用中，可直接登录", this.h.app));
    }

    public void a(Activity activity, ShareStorage.StorageModel storageModel, ILoginConfirmCallback iLoginConfirmCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, storageModel, iLoginConfirmCallback) == null) {
            this.b = activity;
            this.h = storageModel;
            this.i = iLoginConfirmCallback;
            c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareLoginView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = context;
        b();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.setTextColor(Color.parseColor("#CCFFFFFF"));
            this.f.setTextColor(Color.parseColor("#80FFFFFF"));
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e77));
        }
    }
}
