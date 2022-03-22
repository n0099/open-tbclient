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
import c.a.d.a.f;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NoDataView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f30039b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f30040c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f30041d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30042e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f30043f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f30044g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f30045h;
    public TBSpecificationBtn i;
    public TBSpecificationBtn j;
    public int k;
    public View l;
    public NoDataViewFactory.ImgType m;
    public int n;
    public int o;
    public int p;

    /* loaded from: classes5.dex */
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
                a[NoDataViewFactory.ImgType.SINGALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[NoDataViewFactory.ImgType.GIFT.ordinal()] = 8;
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f30045h.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.f30041d.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = r;
                    this.f30041d.setLayoutParams(marginLayoutParams);
                }
                this.f30043f.setVisibility(8);
                this.o = R.color.CAM_X0107;
            } else if (this.f30043f.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams2 = this.f30041d.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.topMargin = r;
                    this.f30041d.setLayoutParams(marginLayoutParams2);
                }
                this.o = R.color.CAM_X0107;
            } else if (this.f30044g.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams3 = this.f30041d.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    marginLayoutParams3.topMargin = t;
                    this.f30041d.setLayoutParams(marginLayoutParams3);
                }
                ViewGroup.LayoutParams layoutParams4 = this.f30044g.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    marginLayoutParams4.topMargin = u;
                    this.f30044g.setLayoutParams(marginLayoutParams4);
                }
                this.o = R.color.CAM_X0107;
                this.p = R.color.CAM_X0109;
            } else {
                ViewGroup.LayoutParams layoutParams5 = this.f30040c.getLayoutParams();
                int i = q;
                layoutParams5.width = i;
                layoutParams5.height = i;
                this.f30040c.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.f30041d.getLayoutParams();
                if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                    marginLayoutParams5.topMargin = s;
                    this.f30041d.setLayoutParams(marginLayoutParams5);
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
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d061d, this);
            this.f30039b = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090fe8);
            this.f30040c = tbImageView;
            tbImageView.setDefaultBgResource(0);
            this.f30040c.setDefaultResource(0);
            this.f30041d = (LinearLayout) this.f30039b.findViewById(R.id.obfuscated_res_0x7f09203d);
            this.f30042e = (TextView) this.f30039b.findViewById(R.id.obfuscated_res_0x7f092218);
            this.f30043f = (TextView) this.f30039b.findViewById(R.id.obfuscated_res_0x7f092213);
            this.f30044g = (TextView) this.f30039b.findViewById(R.id.obfuscated_res_0x7f09221e);
            this.f30045h = (TBSpecificationBtn) this.f30039b.findViewById(R.id.obfuscated_res_0x7f090413);
            c.a.o0.r.l0.n.a aVar = new c.a.o0.r.l0.n.a();
            this.f30045h.setTextSize(R.dimen.T_X05);
            this.f30045h.setConfig(aVar);
            this.l = (LinearLayout) this.f30039b.findViewById(R.id.obfuscated_res_0x7f092233);
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

    public void d(f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            f(fVar, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f30040c.setImageDrawable(null);
            this.f30040c.J(null, 10, false);
        }
    }

    public void f(f<?> fVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, fVar, i) == null) {
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(i == 1);
                tbPageContext.getLayoutMode().j(this);
            }
            TBSpecificationBtn tBSpecificationBtn = this.f30045h;
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
                this.f30040c.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_08));
            } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
                this.f30040c.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_05));
            } else if (imgType == NoDataViewFactory.ImgType.LOCAL) {
                this.f30040c.setImageBitmap(SkinManager.getBitmap565Quality(this.n));
            } else if (imgType == NoDataViewFactory.ImgType.ANTI) {
                this.f30040c.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_05));
            } else if (imgType == NoDataViewFactory.ImgType.NETERROR) {
                this.f30040c.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_08));
            } else {
                this.f30040c.setImageBitmap(SkinManager.getBitmap565Quality(this.k));
            }
        }
    }

    public void g(NoDataViewFactory.d dVar, f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, dVar, fVar) == null) {
            setImgOption(dVar);
            f(fVar, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public TextView getSuTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30043f : (TextView) invokeV.objValue;
    }

    public final void h() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (i = n.i(TbadkCoreApplication.getInst())) <= 0) {
            return;
        }
        int i2 = (int) (i * 0.16d);
        ViewGroup.LayoutParams layoutParams = this.f30040c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f30040c.setLayoutParams(marginLayoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            if (cVar == null) {
                this.f30045h.setVisibility(8);
                this.l.setVisibility(8);
                return;
            }
            NoDataViewFactory.b bVar = cVar.a;
            NoDataViewFactory.b bVar2 = cVar.f30047b;
            if (bVar2 == null && bVar != null) {
                this.f30045h.setOnClickListener(bVar.a);
                this.f30045h.setText(bVar.f30046b);
                this.f30045h.setVisibility(0);
                if (cVar.f30048c >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30045h.getLayoutParams();
                    layoutParams.topMargin = cVar.f30048c;
                    this.f30045h.setLayoutParams(layoutParams);
                }
            }
            if (bVar2 != null && bVar != null) {
                this.i = (TBSpecificationBtn) this.l.findViewById(R.id.obfuscated_res_0x7f09041b);
                this.j = (TBSpecificationBtn) this.l.findViewById(R.id.obfuscated_res_0x7f090436);
                c.a.o0.r.l0.n.a aVar = new c.a.o0.r.l0.n.a();
                this.i.setTextSize(R.dimen.obfuscated_res_0x7f070207);
                this.i.setConfig(aVar);
                this.j.setTextSize(R.dimen.obfuscated_res_0x7f070207);
                this.j.setConfig(aVar);
                this.i.setOnClickListener(bVar.a);
                this.i.setText(bVar.f30046b);
                this.j.setOnClickListener(bVar2.a);
                this.j.setText(bVar2.f30046b);
                this.l.setVisibility(0);
            }
            a();
        }
    }

    public void setImgOption(NoDataViewFactory.d dVar) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) || dVar == null) {
            return;
        }
        NoDataViewFactory.ImgType imgType = dVar.a;
        this.m = imgType;
        this.n = dVar.f30052c;
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
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30040c.getLayoutParams();
        int i2 = dVar.f30051b;
        if (i2 >= 0) {
            layoutParams.setMargins(0, i2, 0, 0);
        }
        int i3 = dVar.f30053d;
        if (i3 > 0 && (i = dVar.f30054e) > 0) {
            layoutParams.height = i3;
            layoutParams.width = i;
        }
        this.f30040c.setLayoutParams(layoutParams);
    }

    public void setRemarkTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (textView = this.f30042e) == null) {
            return;
        }
        SkinManager.setViewTextColor(textView, i, 1);
    }

    public void setSubTitleCompoundDrawable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            Drawable drawable = SkinManager.getDrawable(i);
            int f2 = n.f(this.a, R.dimen.obfuscated_res_0x7f070207);
            int f3 = n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb);
            drawable.setBounds(0, 0, f2, f2);
            this.f30043f.setCompoundDrawablePadding(f3);
            this.f30043f.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void setSubTitleTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (textView = this.f30043f) == null) {
            return;
        }
        SkinManager.setViewTextColor(textView, i, 1);
    }

    public void setSubTitleTextSize(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (textView = this.f30043f) == null) {
            return;
        }
        textView.setTextSize(i);
    }

    public void setTextOption(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) || eVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.a)) {
            this.f30044g.setText(eVar.a);
            this.f30044g.setVisibility(0);
        } else {
            this.f30044g.setVisibility(8);
        }
        if (!TextUtils.isEmpty(eVar.f30059b)) {
            this.f30043f.setVisibility(0);
            this.f30043f.setText(eVar.f30059b);
            if (TextUtils.isEmpty(eVar.a) && eVar.f30061d >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30043f.getLayoutParams();
                layoutParams.topMargin = eVar.f30061d;
                this.f30043f.setLayoutParams(layoutParams);
            }
            int i = eVar.f30062e;
            if (i != 0) {
                setSubTitleCompoundDrawable(i);
            }
        } else {
            this.f30043f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(eVar.f30060c)) {
            this.f30042e.setText(eVar.f30060c);
            this.f30042e.setVisibility(0);
        } else {
            this.f30042e.setVisibility(8);
        }
        a();
    }

    public void setTitleTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || (textView = this.f30044g) == null) {
            return;
        }
        SkinManager.setViewTextColor(textView, i, 1);
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
}
