package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d05;
import com.baidu.tieba.ja5;
import com.baidu.tieba.k9;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NoDataView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TbImageView c;
    public LinearLayout d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TBSpecificationBtn h;
    public TBSpecificationBtn i;
    public TBSpecificationBtn j;
    public int k;
    public View l;
    public NoDataViewFactory.ImgType m;
    public int n;
    public int o;
    public int p;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1067262289, "Lcom/baidu/tbadk/core/view/NoDataView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1067262289, "Lcom/baidu/tbadk/core/view/NoDataView$a;");
                    return;
                }
            }
            int[] iArr = new int[NoDataViewFactory.ImgType.values().length];
            a = iArr;
            try {
                iArr[NoDataViewFactory.ImgType.FINDBAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NoDataViewFactory.ImgType.EMOTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NoDataViewFactory.ImgType.CREATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NoDataViewFactory.ImgType.COLLECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[NoDataViewFactory.ImgType.NODATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[NoDataViewFactory.ImgType.ANTI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[NoDataViewFactory.ImgType.NOPOST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[NoDataViewFactory.ImgType.NOFOLLOW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[NoDataViewFactory.ImgType.WEBVIEW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[NoDataViewFactory.ImgType.NETERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[NoDataViewFactory.ImgType.NOTLOGIN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[NoDataViewFactory.ImgType.NORESULT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1379893458, "Lcom/baidu/tbadk/core/view/NoDataView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1379893458, "Lcom/baidu/tbadk/core/view/NoDataView;");
                return;
            }
        }
        q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
        r = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
        s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
        t = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
        u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoDataView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        b(context, null);
    }

    public void setSubTitleCompoundDrawable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            Drawable drawable = SkinManager.getDrawable(i);
            int g = vi.g(this.a, R.dimen.obfuscated_res_0x7f070207);
            int g2 = vi.g(this.a, R.dimen.obfuscated_res_0x7f070416);
            drawable.setBounds(0, 0, g, g);
            this.f.setCompoundDrawablePadding(g2);
            this.f.setCompoundDrawables(drawable, null, null, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b(context, attributeSet);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.h.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = r;
                    this.d.setLayoutParams(marginLayoutParams);
                }
                this.f.setVisibility(8);
                this.o = R.color.CAM_X0107;
            } else if (this.f.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams2 = this.d.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.topMargin = r;
                    this.d.setLayoutParams(marginLayoutParams2);
                }
                this.o = R.color.CAM_X0107;
            } else if (this.g.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams3 = this.d.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    marginLayoutParams3.topMargin = t;
                    this.d.setLayoutParams(marginLayoutParams3);
                }
                ViewGroup.LayoutParams layoutParams4 = this.g.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    marginLayoutParams4.topMargin = u;
                    this.g.setLayoutParams(marginLayoutParams4);
                }
                this.o = R.color.CAM_X0107;
                this.p = R.color.CAM_X0109;
            } else {
                ViewGroup.LayoutParams layoutParams5 = this.c.getLayoutParams();
                int i = q;
                layoutParams5.width = i;
                layoutParams5.height = i;
                this.c.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.d.getLayoutParams();
                if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                    marginLayoutParams5.topMargin = s;
                    this.d.setLayoutParams(marginLayoutParams5);
                }
                this.p = R.color.CAM_X0109;
            }
            setTitleTextColor(this.o);
            setSubTitleTextColor(this.p);
        }
    }

    public final void b(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.no_data_view, this);
            this.b = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv_no_data_img);
            this.c = tbImageView;
            tbImageView.setDefaultBgResource(0);
            this.c.setDefaultResource(0);
            this.d = (LinearLayout) this.b.findViewById(R.id.title_container);
            this.e = (TextView) this.b.findViewById(R.id.tv_text_reamrk);
            this.f = (TextView) this.b.findViewById(R.id.tv_subtitle);
            this.g = (TextView) this.b.findViewById(R.id.tv_title);
            this.h = (TBSpecificationBtn) this.b.findViewById(R.id.btn_func);
            ja5 ja5Var = new ja5();
            ja5Var.r(R.color.CAM_X0905, R.color.CAM_X0304);
            this.h.setTextSize(R.dimen.T_X05);
            this.h.setConfig(ja5Var);
            this.l = (LinearLayout) this.b.findViewById(R.id.two_button_layout);
            this.o = R.color.CAM_X0107;
            this.p = R.color.CAM_X0109;
            h();
        }
    }

    public void c(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, dVar, eVar) == null) {
            setButtonOption(cVar);
            setImgOption(dVar);
            setTextOption(eVar);
        }
    }

    public void d(k9<?> k9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, k9Var) == null) {
            f(k9Var, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setRemarkTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (textView = this.e) != null) {
            SkinManager.setViewTextColor(textView, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && (textView = this.f) != null) {
            SkinManager.setViewTextColor(textView, i, 1);
        }
    }

    public void setSubTitleTextSize(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (textView = this.f) != null) {
            textView.setTextSize(i);
        }
    }

    public void setTitleTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (textView = this.g) != null) {
            SkinManager.setViewTextColor(textView, i, 1);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setImageDrawable(null);
            this.c.N(null, 10, false);
        }
    }

    public TextView getSuTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public void f(k9<?> k9Var, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, k9Var, i) == null) {
            if (k9Var instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) k9Var;
                d05 layoutMode = tbPageContext.getLayoutMode();
                if (i == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.l(z);
                tbPageContext.getLayoutMode().k(this);
            }
            TBSpecificationBtn tBSpecificationBtn = this.h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.i;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.k();
            }
            TBSpecificationBtn tBSpecificationBtn3 = this.j;
            if (tBSpecificationBtn3 != null) {
                tBSpecificationBtn3.k();
            }
            NoDataViewFactory.ImgType imgType = this.m;
            if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
                WebPManager.setMaskDrawable(this.c, R.drawable.new_pic_emotion_08, null);
            } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
                WebPManager.setMaskDrawable(this.c, R.drawable.new_pic_emotion_05, null);
            } else if (imgType == NoDataViewFactory.ImgType.LOCAL) {
                WebPManager.setMaskDrawable(this.c, this.n, null);
            } else if (imgType == NoDataViewFactory.ImgType.ANTI) {
                WebPManager.setMaskDrawable(this.c, R.drawable.new_pic_emotion_05, null);
            } else if (imgType == NoDataViewFactory.ImgType.NETERROR) {
                WebPManager.setMaskDrawable(this.c, R.drawable.new_pic_emotion_08, null);
            } else {
                WebPManager.setMaskDrawable(this.c, this.k, null);
            }
        }
    }

    public void g(NoDataViewFactory.d dVar, k9<?> k9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, dVar, k9Var) == null) {
            setImgOption(dVar);
            f(k9Var, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setTitleTextColor(int i, int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) && (textView = this.g) != null) {
            SkinManager.setViewTextColor(textView, i, 1, i2);
        }
    }

    public final void h() {
        int j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (j = vi.j(TbadkCoreApplication.getInst())) > 0) {
            int i = (int) (j * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.c.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setButtonOption(NoDataViewFactory.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            if (cVar == null) {
                this.h.setVisibility(8);
                this.l.setVisibility(8);
                return;
            }
            NoDataViewFactory.b bVar = cVar.a;
            NoDataViewFactory.b bVar2 = cVar.b;
            if (bVar2 == null && bVar != null) {
                this.h.setOnClickListener(bVar.a);
                this.h.setText(bVar.b);
                this.h.setVisibility(0);
                if (cVar.c >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
                    layoutParams.topMargin = cVar.c;
                    this.h.setLayoutParams(layoutParams);
                }
            }
            if (bVar2 != null && bVar != null) {
                this.i = (TBSpecificationBtn) this.l.findViewById(R.id.btn_left);
                this.j = (TBSpecificationBtn) this.l.findViewById(R.id.btn_right);
                ja5 ja5Var = new ja5();
                ja5Var.r(R.color.CAM_X0905, R.color.CAM_X0304);
                this.i.setTextSize(R.dimen.obfuscated_res_0x7f070207);
                this.i.setConfig(ja5Var);
                this.j.setTextSize(R.dimen.obfuscated_res_0x7f070207);
                this.j.setConfig(ja5Var);
                this.i.setOnClickListener(bVar.a);
                this.i.setText(bVar.b);
                this.j.setOnClickListener(bVar2.a);
                this.j.setText(bVar2.b);
                this.l.setVisibility(0);
            }
            a();
        }
    }

    public void setImgOption(NoDataViewFactory.d dVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, dVar) != null) || dVar == null) {
            return;
        }
        NoDataViewFactory.ImgType imgType = dVar.a;
        this.m = imgType;
        this.n = dVar.c;
        switch (a.a[imgType.ordinal()]) {
            case 1:
                this.k = R.drawable.new_pic_emotion_01;
                break;
            case 2:
                this.k = R.drawable.new_pic_emotion_02;
                break;
            case 3:
                this.k = R.drawable.new_pic_emotion_03;
                break;
            case 4:
                this.k = R.drawable.new_pic_emotion_04;
                break;
            case 5:
                this.k = R.drawable.new_pic_emotion_05;
                break;
            case 6:
                this.k = R.drawable.new_pic_emotion_05;
                break;
            case 7:
                this.k = R.drawable.new_pic_emotion_06;
                break;
            case 8:
                this.k = R.drawable.new_pic_emotion_07;
                break;
            case 9:
                this.k = R.drawable.new_pic_emotion_08;
                break;
            case 10:
                this.k = R.drawable.new_pic_emotion_08;
                break;
            case 11:
                this.k = R.drawable.new_pic_emotion_09;
                break;
            case 12:
                this.k = R.drawable.new_pic_emotion_10;
                break;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        int i2 = dVar.b;
        if (i2 >= 0) {
            layoutParams.setMargins(0, i2, 0, 0);
        }
        int i3 = dVar.d;
        if (i3 > 0 && (i = dVar.e) > 0) {
            layoutParams.height = i3;
            layoutParams.width = i;
        }
        this.c.setLayoutParams(layoutParams);
    }

    public void setTextOption(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, eVar) != null) || eVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.a)) {
            this.g.setText(eVar.a);
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
        if (!TextUtils.isEmpty(eVar.b)) {
            this.f.setVisibility(0);
            this.f.setText(eVar.b);
            if (TextUtils.isEmpty(eVar.a) && eVar.d >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
                layoutParams.topMargin = eVar.d;
                this.f.setLayoutParams(layoutParams);
            }
            int i = eVar.e;
            if (i != 0) {
                setSubTitleCompoundDrawable(i);
            }
        } else {
            this.f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(eVar.c)) {
            this.e.setText(eVar.c);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        a();
    }
}
