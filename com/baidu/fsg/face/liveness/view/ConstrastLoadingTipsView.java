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
    public TextView f6087a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f6088b;

    /* renamed from: c  reason: collision with root package name */
    public b f6089c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6090d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f6091e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f6092f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f6093g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f6094h;

    /* renamed from: i  reason: collision with root package name */
    public a f6095i;

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
        public final /* synthetic */ ConstrastLoadingTipsView f6098a;

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
            this.f6098a = constrastLoadingTipsView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6098a.f6087a.setVisibility(8);
                this.f6098a.f6088b.setVisibility(0);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                TextView textView = this.f6098a.f6087a;
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
            this.f6089c = bVar;
            bVar.start();
            if (!TextUtils.isEmpty(confirmBean.confirm_msg)) {
                this.f6090d.setText(confirmBean.confirm_msg);
            }
            if (!TextUtils.isEmpty(confirmBean.cancel_msg)) {
                this.f6091e.setText(confirmBean.cancel_msg);
            }
            TextView textView = this.f6087a;
            textView.setText(confirmBean.tips_sec + "");
            if (!uploadContrastPortraitModel.isContrastPass()) {
                this.f6092f.setVisibility(8);
            }
            if (!TextUtils.isEmpty(confirmBean.tip_msg)) {
                this.f6094h.setText(confirmBean.tip_msg);
            }
            if (TextUtils.isEmpty(confirmBean.title_tips)) {
                return;
            }
            this.f6093g.setText(confirmBean.title_tips);
        }
    }

    public void setOnClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f6095i = aVar;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                this.f6089c.start();
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.rim_face_result_tips_pages, this);
            this.f6087a = (TextView) findViewById(R.id.rim_face_result_tips_time_tv);
            this.f6088b = (LinearLayout) findViewById(R.id.rim_face_result_tips_btn_ll);
            this.f6090d = (TextView) findViewById(R.id.rim_face_result_tips_confirm);
            this.f6091e = (TextView) findViewById(R.id.rim_face_result_tips_cancel);
            this.f6092f = (ImageView) findViewById(R.id.rim_face_result_tips_pages_img);
            this.f6094h = (TextView) findViewById(R.id.rim_face_result_tips_pages_tips_msg);
            this.f6093g = (TextView) findViewById(R.id.rim_face_result_tips_pages_tips_title);
            this.f6087a.setVisibility(0);
            this.f6088b.setVisibility(8);
            this.f6090d.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ConstrastLoadingTipsView f6096a;

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
                    this.f6096a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f6096a.f6095i.a();
                    }
                }
            });
            this.f6091e.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ConstrastLoadingTipsView f6097a;

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
                    this.f6097a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f6097a.f6095i.b();
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
