package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import b.a.w.b.f.a;
import b.a.w.c.a.c;
import b.a.w.c.a.d;
import b.a.w.c.a.e;
import b.a.w.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes7.dex */
public class EmptyView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDraweeView f38800e;

    /* renamed from: f  reason: collision with root package name */
    public AppCompatTextView f38801f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyView(Context context) {
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

    public void onDarkModeChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f38800e.getLayoutParams();
            layoutParams.width = a.a(getContext(), b.a.w.b.g.b.a.a().f29262i);
            layoutParams.height = a.a(getContext(), b.a.w.b.g.b.a.a().j);
            this.f38800e.setLayoutParams(layoutParams);
            setImageResource(f.e().b(z));
            if ("quanmin".equals(LiveFeedPageSdk.e().d())) {
                this.f38801f.setText(e.live_feed_no_data_qm);
            } else {
                this.f38801f.setText(e.live_feed_no_data);
            }
            this.f38801f.setTextColor(f.e().a(getContext(), z, "color_8585852"));
        }
    }

    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == -1) {
            return;
        }
        this.f38800e.setActualImageResource(i2);
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
            this.f38801f.setText(charSequence);
        }
    }

    public void toggleVisible(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                onDarkModeChange(z);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyView(Context context, @Nullable AttributeSet attributeSet) {
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

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f38801f.setText(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        LayoutInflater.from(context).inflate(d.live_feed_page_empty_view, this);
        setOrientation(1);
        setGravity(17);
        this.f38800e = (SimpleDraweeView) findViewById(c.empty_image);
        this.f38801f = (AppCompatTextView) findViewById(c.empty_text);
    }
}
