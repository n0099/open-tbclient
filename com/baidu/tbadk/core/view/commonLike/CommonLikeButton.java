package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import c.a.e.e.p.l;
import c.a.p0.s.f0.o.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f47826e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47827f;
    public boolean mCurrentIsLike;
    public String mStrAlreadyFollowed;
    public String mStrFollow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonLikeButton(Context context) {
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
        this.mStrAlreadyFollowed = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.mStrFollow = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.mCurrentIsLike = false;
        this.f47827f = false;
        init();
    }

    @Override // c.a.p0.s.f0.o.b
    public void bindOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setSingleLine();
            setIncludeFontPadding(false);
            setTextSize(0, l.g(getContext(), R.dimen.tbds34));
            setGravity(17);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.mCurrentIsLike) {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this, R.color.CAM_X0109);
                setBackgroundDrawable(null);
                return;
            }
            setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.btn_forum_focus_color);
            if (this.f47827f) {
                SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
            } else {
                SkinManager.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
            }
        }
    }

    @Override // c.a.p0.s.f0.o.b
    public void onClickEvent(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (onClickListener = this.f47826e) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f47826e = onClickListener;
        }
    }

    public void setBackGroundIsTransMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f47827f = z;
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    @Override // c.a.p0.s.f0.o.b
    public void updateLikeStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            setVisibility(0);
            this.mCurrentIsLike = z;
            if (z) {
                setClickable(false);
                setText(this.mStrAlreadyFollowed);
                setPadding(0, 0, 0, 0);
            } else {
                setClickable(true);
                setText(this.mStrFollow);
                setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonLikeButton(Context context, AttributeSet attributeSet) {
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
        this.mStrAlreadyFollowed = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.mStrFollow = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.mCurrentIsLike = false;
        this.f47827f = false;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonLikeButton(Context context, AttributeSet attributeSet, int i2) {
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
        this.mStrAlreadyFollowed = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.mStrFollow = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.mCurrentIsLike = false;
        this.f47827f = false;
        init();
    }
}
