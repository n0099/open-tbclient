package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import c.a.x.c.a.c;
import c.a.x.c.a.d;
import c.a.x.c.a.e;
import c.a.x.k.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.util.NetWorkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes10.dex */
public class ErrorView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34815e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDraweeView f34816f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34817g;

    /* renamed from: h  reason: collision with root package name */
    public b f34818h;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ErrorView f34819e;

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
            this.f34819e = errorView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (NetWorkUtils.b(this.f34819e.getContext())) {
                    if (this.f34819e.f34818h != null) {
                        this.f34819e.f34818h.a(view);
                        return;
                    }
                    return;
                }
                Toast.makeText(this.f34819e.getContext(), e.live_feed_net_error, 1).show();
            }
        }
    }

    /* loaded from: classes10.dex */
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
            this.f34815e.setOnClickListener(new a(this));
        }
    }

    public void onDarkModeChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (NetWorkUtils.b(getContext())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34816f.getLayoutParams();
                layoutParams.width = c.a.x.b.f.a.a(getContext(), c.a.x.b.g.b.a.a().o);
                layoutParams.height = c.a.x.b.f.a.a(getContext(), c.a.x.b.g.b.a.a().p);
                this.f34816f.setLayoutParams(layoutParams);
                setImageResource(f.e().c(z));
                this.f34817g.setText(e.live_feed_load_error);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f34816f.getLayoutParams();
                layoutParams2.width = c.a.x.b.f.a.a(getContext(), c.a.x.b.g.b.a.a().u);
                layoutParams2.height = c.a.x.b.f.a.a(getContext(), c.a.x.b.g.b.a.a().v);
                this.f34816f.setLayoutParams(layoutParams2);
                setImageResource(f.e().d(z));
                this.f34817g.setText(e.live_feed_net_error);
            }
            this.f34817g.setTextColor(f.e().a(getContext(), z, "color_8585852"));
            this.f34815e.setTextColor(f.e().a(getContext(), z, "color_5252522"));
            this.f34815e.setBackground(f.e().m(getContext(), z));
        }
    }

    public void performActionCallback() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f34818h) == null) {
            return;
        }
        bVar.a(this.f34815e);
    }

    public void setActionCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f34818h = bVar;
        }
    }

    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 == -1) {
            return;
        }
        this.f34816f.setActualImageResource(i2);
    }

    public void toggleVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            toggleVisible(i2, false);
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

    public void toggleVisible(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                onDarkModeChange(z);
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
        this.f34816f = (SimpleDraweeView) findViewById(c.errorview_img);
        this.f34815e = (TextView) findViewById(c.errorview_clickreload);
        this.f34817g = (TextView) findViewById(c.errorview_desc);
        onBindListener();
    }
}
