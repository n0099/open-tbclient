package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.liveness.datamodel.UploadContrastPortraitModel;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ConstrastLoadingTipsView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f6113a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f6114b;

    /* renamed from: c  reason: collision with root package name */
    public b f6115c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6116d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f6117e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f6118f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f6119g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f6120h;

    /* renamed from: i  reason: collision with root package name */
    public a f6121i;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConstrastLoadingTipsView f6124a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ConstrastLoadingTipsView constrastLoadingTipsView, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constrastLoadingTipsView, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6124a = constrastLoadingTipsView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6124a.f6113a.setVisibility(8);
                this.f6124a.f6114b.setVisibility(0);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                TextView textView = this.f6124a.f6113a;
                textView.setText((j / 1000) + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrastLoadingTipsView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public void initData(UploadContrastPortraitModel uploadContrastPortraitModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uploadContrastPortraitModel) == null) {
            UploadContrastPortraitModel.ConfirmBean confirmBean = uploadContrastPortraitModel.getConfirmBean();
            if (confirmBean.tips_sec == 0) {
                confirmBean.tips_sec = 5;
            }
            b bVar = new b(this, (confirmBean.tips_sec * 1000) + 1000, 1000L);
            this.f6115c = bVar;
            bVar.start();
            if (!TextUtils.isEmpty(confirmBean.confirm_msg)) {
                this.f6116d.setText(confirmBean.confirm_msg);
            }
            if (!TextUtils.isEmpty(confirmBean.cancel_msg)) {
                this.f6117e.setText(confirmBean.cancel_msg);
            }
            TextView textView = this.f6113a;
            textView.setText(confirmBean.tips_sec + "");
            if (!uploadContrastPortraitModel.isContrastPass()) {
                this.f6118f.setVisibility(8);
            }
            if (!TextUtils.isEmpty(confirmBean.tip_msg)) {
                this.f6120h.setText(confirmBean.tip_msg);
            }
            if (TextUtils.isEmpty(confirmBean.title_tips)) {
                return;
            }
            this.f6119g.setText(confirmBean.title_tips);
        }
    }

    public void setOnClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f6121i = aVar;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                this.f6115c.start();
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.rim_face_result_tips_pages, this);
            this.f6113a = (TextView) findViewById(R.id.rim_face_result_tips_time_tv);
            this.f6114b = (LinearLayout) findViewById(R.id.rim_face_result_tips_btn_ll);
            this.f6116d = (TextView) findViewById(R.id.rim_face_result_tips_confirm);
            this.f6117e = (TextView) findViewById(R.id.rim_face_result_tips_cancel);
            this.f6118f = (ImageView) findViewById(R.id.rim_face_result_tips_pages_img);
            this.f6120h = (TextView) findViewById(R.id.rim_face_result_tips_pages_tips_msg);
            this.f6119g = (TextView) findViewById(R.id.rim_face_result_tips_pages_tips_title);
            this.f6113a.setVisibility(0);
            this.f6114b.setVisibility(8);
            this.f6116d.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ConstrastLoadingTipsView f6122a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6122a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f6122a.f6121i.a();
                    }
                }
            });
            this.f6117e.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ConstrastLoadingTipsView f6123a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6123a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f6123a.f6121i.b();
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrastLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }
}
