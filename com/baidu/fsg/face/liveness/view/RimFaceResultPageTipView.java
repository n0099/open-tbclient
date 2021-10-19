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
/* loaded from: classes5.dex */
public class RimFaceResultPageTipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f40492a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f40493b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f40494c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40495d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40496e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40497f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f40498g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f40499h;

    /* renamed from: i  reason: collision with root package name */
    public a f40500i;

    /* renamed from: j  reason: collision with root package name */
    public b f40501j;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
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
            this.f40494c.setVisibility(4);
            this.f40495d.setVisibility(4);
            this.f40496e.setVisibility(4);
            this.f40499h.setVisibility(4);
            this.f40498g.setVisibility(4);
            this.f40492a.setVisibility(4);
            this.f40493b.setVisibility(4);
            this.f40501j = null;
            this.f40500i = null;
        }
    }

    public void setOnClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f40500i = aVar;
        }
    }

    public void setOnCloseListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f40501j = bVar;
            this.f40499h.setVisibility(0);
        }
    }

    public void setResultPageCancelText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f40492a.setVisibility(0);
        this.f40492a.setText(str);
    }

    public void setResultPageConfirmText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f40493b.setVisibility(0);
        this.f40493b.setText(str);
    }

    public void setResultPageImg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f40494c.setVisibility(0);
            this.f40494c.setBackgroundResource(i2);
        }
    }

    public void setResultPageNextTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f40496e.setTextSize(13.0f);
        this.f40496e.setTextColor(getResources().getColor(R.color.rim_base_text_666666));
        this.f40496e.setText(str);
        this.f40496e.setVisibility(0);
    }

    public void setResultPageNextTitleBold(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f40496e.setTextSize(18.0f);
        this.f40496e.setTextColor(getResources().getColor(R.color.rim_base_text_333333));
        this.f40496e.setText(str);
        this.f40496e.setVisibility(0);
    }

    public void setResultPageRiskTipVisiable(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f40497f.setText(str);
        this.f40498g.setVisibility(0);
    }

    public void setResultPageTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f40495d.setText(str);
        this.f40495d.setVisibility(0);
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
            this.f40494c = (ImageView) findViewById(R.id.rim_face_result_page_img);
            this.f40499h = (ImageView) findViewById(R.id.rim_face_result_page_close_img);
            this.f40495d = (TextView) findViewById(R.id.rim_face_result_tips_title);
            this.f40496e = (TextView) findViewById(R.id.rim_face_result_tips_next_title);
            this.f40497f = (TextView) findViewById(R.id.rim_face_result_page_tip_msg);
            this.f40498g = (LinearLayout) findViewById(R.id.layout_result_page_show_risk_tip);
            this.f40493b = (TextView) findViewById(R.id.rim_face_result_page_confirm);
            this.f40492a = (TextView) findViewById(R.id.rim_face_result_page_cancel);
            this.f40499h.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RimFaceResultPageTipView f40502a;

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
                    this.f40502a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f40502a.f40501j == null) {
                        return;
                    }
                    this.f40502a.f40501j.a();
                }
            });
            this.f40493b.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RimFaceResultPageTipView f40503a;

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
                    this.f40503a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f40503a.f40500i == null) {
                        return;
                    }
                    this.f40503a.f40500i.a();
                }
            });
            this.f40492a.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RimFaceResultPageTipView f40504a;

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
                    this.f40504a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f40504a.f40500i == null) {
                        return;
                    }
                    this.f40504a.f40500i.b();
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
