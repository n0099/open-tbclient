package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class RimFaceResultPageTipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f6195a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6196b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f6197c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6198d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f6199e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f6200f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f6201g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f6202h;

    /* renamed from: i  reason: collision with root package name */
    public a f6203i;
    public b j;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RimFaceResultPageTipView(Context context) {
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

    public void resetView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f6197c.setVisibility(4);
            this.f6198d.setVisibility(4);
            this.f6199e.setVisibility(4);
            this.f6202h.setVisibility(4);
            this.f6201g.setVisibility(4);
            this.f6195a.setVisibility(4);
            this.f6196b.setVisibility(4);
            this.j = null;
            this.f6203i = null;
        }
    }

    public void setOnClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f6203i = aVar;
        }
    }

    public void setOnCloseListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.j = bVar;
            this.f6202h.setVisibility(0);
        }
    }

    public void setResultPageCancelText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6195a.setVisibility(0);
        this.f6195a.setText(str);
    }

    public void setResultPageConfirmText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6196b.setVisibility(0);
        this.f6196b.setText(str);
    }

    public void setResultPageImg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f6197c.setVisibility(0);
            this.f6197c.setBackgroundResource(i2);
        }
    }

    public void setResultPageNextTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6199e.setTextSize(13.0f);
        this.f6199e.setTextColor(getResources().getColor(R.color.rim_base_text_666666));
        this.f6199e.setText(str);
        this.f6199e.setVisibility(0);
    }

    public void setResultPageNextTitleBold(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6199e.setTextSize(18.0f);
        this.f6199e.setTextColor(getResources().getColor(R.color.rim_base_text_333333));
        this.f6199e.setText(str);
        this.f6199e.setVisibility(0);
    }

    public void setResultPageRiskTipVisiable(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6200f.setText(str);
        this.f6201g.setVisibility(0);
    }

    public void setResultPageTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6198d.setText(str);
        this.f6198d.setVisibility(0);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.setVisibility(i2);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.rim_face_risk_warning_tips_page, this);
            this.f6197c = (ImageView) findViewById(R.id.rim_face_result_page_img);
            this.f6202h = (ImageView) findViewById(R.id.rim_face_result_page_close_img);
            this.f6198d = (TextView) findViewById(R.id.rim_face_result_tips_title);
            this.f6199e = (TextView) findViewById(R.id.rim_face_result_tips_next_title);
            this.f6200f = (TextView) findViewById(R.id.rim_face_result_page_tip_msg);
            this.f6201g = (LinearLayout) findViewById(R.id.layout_result_page_show_risk_tip);
            this.f6196b = (TextView) findViewById(R.id.rim_face_result_page_confirm);
            this.f6195a = (TextView) findViewById(R.id.rim_face_result_page_cancel);
            this.f6202h.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RimFaceResultPageTipView f6204a;

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
                    this.f6204a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f6204a.j == null) {
                        return;
                    }
                    this.f6204a.j.a();
                }
            });
            this.f6196b.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RimFaceResultPageTipView f6205a;

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
                    this.f6205a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f6205a.f6203i == null) {
                        return;
                    }
                    this.f6205a.f6203i.a();
                }
            });
            this.f6195a.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RimFaceResultPageTipView f6206a;

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
                    this.f6206a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f6206a.f6203i == null) {
                        return;
                    }
                    this.f6206a.f6203i.b();
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RimFaceResultPageTipView(Context context, AttributeSet attributeSet) {
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
