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
import b.a.e.a.f;
import b.a.e.e.p.l;
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
/* loaded from: classes8.dex */
public class NoDataView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f45311e;

    /* renamed from: f  reason: collision with root package name */
    public View f45312f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f45313g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f45314h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f45315i;
    public TextView j;
    public TextView k;
    public TBSpecificationBtn l;
    public TBSpecificationBtn m;
    public TBSpecificationBtn n;
    public int o;
    public View p;
    public NoDataViewFactory.ImgType q;
    public int r;
    public int s;
    public int t;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45316a;
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
            f45316a = iArr;
            try {
                iArr[NoDataViewFactory.ImgType.FINDBAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45316a[NoDataViewFactory.ImgType.EMOTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45316a[NoDataViewFactory.ImgType.CREATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45316a[NoDataViewFactory.ImgType.COLLECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45316a[NoDataViewFactory.ImgType.NODATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45316a[NoDataViewFactory.ImgType.ANTI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45316a[NoDataViewFactory.ImgType.SINGALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f45316a[NoDataViewFactory.ImgType.GIFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f45316a[NoDataViewFactory.ImgType.WEBVIEW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f45316a[NoDataViewFactory.ImgType.NETERROR.ordinal()] = 10;
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
        u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
        v = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
        w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
        x = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
        y = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45311e = context;
        b(context, null);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.l.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.f45314h.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = v;
                    this.f45314h.setLayoutParams(marginLayoutParams);
                }
                this.j.setVisibility(8);
                this.s = R.color.CAM_X0107;
            } else if (this.j.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams2 = this.f45314h.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.topMargin = v;
                    this.f45314h.setLayoutParams(marginLayoutParams2);
                }
                this.s = R.color.CAM_X0107;
            } else if (this.k.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams3 = this.f45314h.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    marginLayoutParams3.topMargin = x;
                    this.f45314h.setLayoutParams(marginLayoutParams3);
                }
                ViewGroup.LayoutParams layoutParams4 = this.k.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    marginLayoutParams4.topMargin = y;
                    this.k.setLayoutParams(marginLayoutParams4);
                }
                this.s = R.color.CAM_X0107;
                this.t = R.color.CAM_X0109;
            } else {
                ViewGroup.LayoutParams layoutParams5 = this.f45313g.getLayoutParams();
                int i2 = u;
                layoutParams5.width = i2;
                layoutParams5.height = i2;
                this.f45313g.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.f45314h.getLayoutParams();
                if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                    marginLayoutParams5.topMargin = w;
                    this.f45314h.setLayoutParams(marginLayoutParams5);
                }
                this.t = R.color.CAM_X0109;
            }
            setTitleTextColor(this.s);
            setSubTitleTextColor(this.t);
        }
    }

    public final void b(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
            View inflate = LayoutInflater.from(this.f45311e).inflate(R.layout.no_data_view, this);
            this.f45312f = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv_no_data_img);
            this.f45313g = tbImageView;
            tbImageView.setDefaultBgResource(0);
            this.f45313g.setDefaultResource(0);
            this.f45314h = (LinearLayout) this.f45312f.findViewById(R.id.title_container);
            this.f45315i = (TextView) this.f45312f.findViewById(R.id.tv_text_reamrk);
            this.j = (TextView) this.f45312f.findViewById(R.id.tv_subtitle);
            this.k = (TextView) this.f45312f.findViewById(R.id.tv_title);
            this.l = (TBSpecificationBtn) this.f45312f.findViewById(R.id.btn_func);
            b.a.q0.s.g0.n.a aVar = new b.a.q0.s.g0.n.a();
            this.l.setTextSize(R.dimen.T_X05);
            this.l.setConfig(aVar);
            this.p = (LinearLayout) this.f45312f.findViewById(R.id.two_button_layout);
            this.s = R.color.CAM_X0107;
            this.t = R.color.CAM_X0109;
            c();
        }
    }

    public final void c() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (i2 = l.i(TbadkCoreApplication.getInst())) <= 0) {
            return;
        }
        int i3 = (int) (i2 * 0.16d);
        ViewGroup.LayoutParams layoutParams = this.f45313g.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i3;
            this.f45313g.setLayoutParams(marginLayoutParams);
        }
    }

    public TextView getSuTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public void initView(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, cVar, dVar, eVar) == null) {
            setButtonOption(cVar);
            setImgOption(dVar);
            setTextOption(eVar);
        }
    }

    public void onActivityStart(f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f45313g.setImageDrawable(null);
            this.f45313g.startLoad(null, 10, false);
        }
    }

    public void onChangeSkinType(f<?> fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, fVar, i2) == null) {
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(this);
            }
            TBSpecificationBtn tBSpecificationBtn = this.l;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.m;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.changeSkinType();
            }
            TBSpecificationBtn tBSpecificationBtn3 = this.n;
            if (tBSpecificationBtn3 != null) {
                tBSpecificationBtn3.changeSkinType();
            }
            NoDataViewFactory.ImgType imgType = this.q;
            if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
                this.f45313g.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_08));
            } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
                this.f45313g.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_05));
            } else if (imgType == NoDataViewFactory.ImgType.LOCAL) {
                this.f45313g.setImageBitmap(SkinManager.getBitmap565Quality(this.r));
            } else if (imgType == NoDataViewFactory.ImgType.ANTI) {
                this.f45313g.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_05));
            } else if (imgType == NoDataViewFactory.ImgType.NETERROR) {
                this.f45313g.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_08));
            } else {
                this.f45313g.setImageBitmap(SkinManager.getBitmap565Quality(this.o));
            }
        }
    }

    public void resetImageOptipn(NoDataViewFactory.d dVar, f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, fVar) == null) {
            setImgOption(dVar);
            onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setButtonOption(NoDataViewFactory.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            if (cVar == null) {
                this.l.setVisibility(8);
                this.p.setVisibility(8);
                return;
            }
            NoDataViewFactory.b bVar = cVar.f45319a;
            NoDataViewFactory.b bVar2 = cVar.f45320b;
            if (bVar2 == null && bVar != null) {
                this.l.setOnClickListener(bVar.f45317a);
                this.l.setText(bVar.f45318b);
                this.l.setVisibility(0);
                if (cVar.f45321c >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
                    layoutParams.topMargin = cVar.f45321c;
                    this.l.setLayoutParams(layoutParams);
                }
            }
            if (bVar2 != null && bVar != null) {
                this.m = (TBSpecificationBtn) this.p.findViewById(R.id.btn_left);
                this.n = (TBSpecificationBtn) this.p.findViewById(R.id.btn_right);
                b.a.q0.s.g0.n.a aVar = new b.a.q0.s.g0.n.a();
                this.m.setTextSize(R.dimen.ds32);
                this.m.setConfig(aVar);
                this.n.setTextSize(R.dimen.ds32);
                this.n.setConfig(aVar);
                this.m.setOnClickListener(bVar.f45317a);
                this.m.setText(bVar.f45318b);
                this.n.setOnClickListener(bVar2.f45317a);
                this.n.setText(bVar2.f45318b);
                this.p.setVisibility(0);
            }
            a();
        }
    }

    public void setImgOption(NoDataViewFactory.d dVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) || dVar == null) {
            return;
        }
        NoDataViewFactory.ImgType imgType = dVar.f45325a;
        this.q = imgType;
        this.r = dVar.f45327c;
        switch (a.f45316a[imgType.ordinal()]) {
            case 1:
                this.o = R.drawable.new_pic_emotion_01;
                break;
            case 2:
                this.o = R.drawable.new_pic_emotion_02;
                break;
            case 3:
                this.o = R.drawable.new_pic_emotion_03;
                break;
            case 4:
                this.o = R.drawable.new_pic_emotion_04;
                break;
            case 5:
                this.o = R.drawable.new_pic_emotion_05;
                break;
            case 6:
                this.o = R.drawable.new_pic_emotion_05;
                break;
            case 7:
                this.o = R.drawable.new_pic_emotion_06;
                break;
            case 8:
                this.o = R.drawable.new_pic_emotion_07;
                break;
            case 9:
                this.o = R.drawable.new_pic_emotion_08;
                break;
            case 10:
                this.o = R.drawable.new_pic_emotion_08;
                break;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f45313g.getLayoutParams();
        int i3 = dVar.f45326b;
        if (i3 >= 0) {
            layoutParams.setMargins(0, i3, 0, 0);
        }
        int i4 = dVar.f45328d;
        if (i4 > 0 && (i2 = dVar.f45329e) > 0) {
            layoutParams.height = i4;
            layoutParams.width = i2;
        }
        this.f45313g.setLayoutParams(layoutParams);
    }

    public void setRemarkTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (textView = this.f45315i) == null) {
            return;
        }
        SkinManager.setViewTextColor(textView, i2, 1);
    }

    public void setSubTitleCompoundDrawable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            Drawable drawable = SkinManager.getDrawable(i2);
            int g2 = l.g(this.f45311e, R.dimen.ds32);
            int g3 = l.g(this.f45311e, R.dimen.ds8);
            drawable.setBounds(0, 0, g2, g2);
            this.j.setCompoundDrawablePadding(g3);
            this.j.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void setSubTitleTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (textView = this.j) == null) {
            return;
        }
        SkinManager.setViewTextColor(textView, i2, 1);
    }

    public void setSubTitleTextSize(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setTextSize(i2);
    }

    public void setTextOption(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) || eVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.f45335a)) {
            this.k.setText(eVar.f45335a);
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        if (!TextUtils.isEmpty(eVar.f45336b)) {
            this.j.setVisibility(0);
            this.j.setText(eVar.f45336b);
            if (TextUtils.isEmpty(eVar.f45335a) && eVar.f45338d >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams.topMargin = eVar.f45338d;
                this.j.setLayoutParams(layoutParams);
            }
            int i2 = eVar.f45339e;
            if (i2 != 0) {
                setSubTitleCompoundDrawable(i2);
            }
        } else {
            this.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(eVar.f45337c)) {
            this.f45315i.setText(eVar.f45337c);
            this.f45315i.setVisibility(0);
        } else {
            this.f45315i.setVisibility(8);
        }
        a();
    }

    public void setTitleTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (textView = this.k) == null) {
            return;
        }
        SkinManager.setViewTextColor(textView, i2, 1);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
