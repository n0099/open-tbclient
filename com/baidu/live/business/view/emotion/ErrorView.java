package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import c.a.w.c.a.c;
import c.a.w.c.a.d;
import c.a.w.c.a.e;
import c.a.w.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.util.NetWorkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class ErrorView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40744e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDraweeView f40745f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40746g;

    /* renamed from: h  reason: collision with root package name */
    public b f40747h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ErrorView f40748e;

        public a(ErrorView errorView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {errorView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40748e = errorView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (NetWorkUtils.b(this.f40748e.getContext())) {
                    if (this.f40748e.f40747h != null) {
                        this.f40748e.f40747h.a(view);
                        return;
                    }
                    return;
                }
                Toast.makeText(this.f40748e.getContext(), e.live_feed_net_error, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void onBindListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f40744e.setOnClickListener(new a(this));
        }
    }

    public void onDarkModeChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (NetWorkUtils.b(getContext())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f40745f.getLayoutParams();
                layoutParams.width = c.a.w.b.f.a.a(getContext(), c.a.w.b.g.b.a.a().o);
                layoutParams.height = c.a.w.b.f.a.a(getContext(), c.a.w.b.g.b.a.a().p);
                this.f40745f.setLayoutParams(layoutParams);
                setImageResource(f.e().c(z));
                this.f40746g.setText(e.live_feed_load_error);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f40745f.getLayoutParams();
                layoutParams2.width = c.a.w.b.f.a.a(getContext(), c.a.w.b.g.b.a.a().u);
                layoutParams2.height = c.a.w.b.f.a.a(getContext(), c.a.w.b.g.b.a.a().v);
                this.f40745f.setLayoutParams(layoutParams2);
                setImageResource(f.e().d(z));
                this.f40746g.setText(e.live_feed_net_error);
            }
            this.f40746g.setTextColor(f.e().a(getContext(), z, "color_8585852"));
            this.f40744e.setTextColor(f.e().a(getContext(), z, "color_5252522"));
            this.f40744e.setBackground(f.e().m(getContext(), z));
        }
    }

    public void performActionCallback() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f40747h) == null) {
            return;
        }
        bVar.a(this.f40744e);
    }

    public void setActionCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f40747h = bVar;
        }
    }

    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 == -1) {
            return;
        }
        this.f40745f.setActualImageResource(i2);
    }

    public void toggleVisible(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                onDarkModeChange(z);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        LayoutInflater.from(getContext()).inflate(d.live_feed_page_error_view, this);
        setOrientation(1);
        setGravity(17);
        this.f40745f = (SimpleDraweeView) findViewById(c.errorview_img);
        this.f40744e = (TextView) findViewById(c.errorview_clickreload);
        this.f40746g = (TextView) findViewById(c.errorview_desc);
        onBindListener();
    }
}
