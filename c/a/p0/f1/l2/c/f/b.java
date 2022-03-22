package c.a.p0.f1.l2.c.f;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b implements c.a.p0.f1.l2.c.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f14218b;

    /* renamed from: c  reason: collision with root package name */
    public String f14219c;

    /* renamed from: d  reason: collision with root package name */
    public String f14220d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14221e;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f14222b;

        public a(b bVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14222b = bVar;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.r.j0.b.k().u("key_should_show_frs_new_tag", false);
                this.f14222b.a.f14227f.setVisibility(8);
                this.a.onClick(view);
            }
        }
    }

    /* renamed from: c.a.p0.f1.l2.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C1068b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-797291650, "Lc/a/p0/f1/l2/c/f/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-797291650, "Lc/a/p0/f1/l2/c/f/b$b;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.SPEED_ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.BRAND_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f14223b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14224c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14225d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14226e;

        /* renamed from: f  reason: collision with root package name */
        public MessageRedDotView f14227f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f14228g;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @NonNull
        public static c a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
                c cVar = new c();
                cVar.a = view;
                cVar.f14223b = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f09246e);
                cVar.f14224c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09246c);
                cVar.f14225d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092469);
                cVar.f14226e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c5b);
                cVar.f14227f = (MessageRedDotView) view.findViewById(R.id.obfuscated_res_0x7f09155e);
                cVar.f14228g = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092472);
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    public b(@NonNull FrsFragment frsFragment, @NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14218b = view.getContext();
        c a2 = c.a(view);
        this.a = a2;
        a2.f14223b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.f14223b.setPageId(frsFragment.getUniqueId());
        this.a.f14223b.setContentDescription(view.getResources().getString(R.string.obfuscated_res_0x7f0f02d1));
        this.a.f14223b.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.a.f14223b.setShowOval(true);
        this.a.f14223b.setPlaceHolder(1);
        this.a.f14223b.setTag(R.id.obfuscated_res_0x7f090659, LogicField.INFO_AREA);
        this.a.f14224c.setTag(R.id.obfuscated_res_0x7f090659, LogicField.INFO_AREA);
        if (c.a.o0.r.j0.b.k().h("key_should_show_frs_new_tag", true)) {
            this.a.f14227f.setEnterForumStyle(true);
            this.a.f14227f.setFixMeasuredWidthHeight(true);
            this.a.f14227f.g(view.getResources().getString(R.string.obfuscated_res_0x7f0f066b), false);
            this.a.f14227f.setVisibility(0);
        }
    }

    @Override // c.a.p0.f1.l2.c.f.a
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            if (C1068b.a[logicField.ordinal()] != 1) {
                return null;
            }
            return (T) this.a.f14228g;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.p0.f1.l2.c.f.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f14221e = z;
            this.a.f14226e.setText(z ? this.f14220d : this.f14219c);
            this.a.f14228g.setVisibility(z ? 0 : 8);
        }
    }

    @Override // c.a.p0.f1.l2.c.f.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            a aVar = new a(this, onClickListener);
            this.a.f14223b.setOnClickListener(aVar);
            this.a.f14224c.setOnClickListener(aVar);
            this.a.f14226e.setOnClickListener(onClickListener);
        }
    }

    @Override // c.a.p0.f1.l2.c.f.a
    public void g(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            String format = String.format(this.f14218b.getString(R.string.obfuscated_res_0x7f0f09d4), this.f14218b.getString(R.string.obfuscated_res_0x7f0f0a6b, Integer.valueOf(i)), str);
            this.f14220d = format;
            if (this.f14221e) {
                this.a.f14226e.setText(format);
                this.a.f14226e.setTag(R.id.obfuscated_res_0x7f090659, LogicField.LEVEL_AND_LEVEL_NAME);
                this.a.f14228g.setVisibility(0);
            }
        }
    }

    @Override // c.a.p0.f1.l2.c.f.a
    public void j(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String format = String.format(this.f14218b.getString(R.string.obfuscated_res_0x7f0f029d), StringHelper.numberUniformFormatExtraWithRoundInt(j), StringHelper.numberUniformFormatExtraWithRoundInt(j2));
            this.f14219c = format;
            if (this.f14221e) {
                return;
            }
            this.a.f14226e.setText(format);
            this.a.f14226e.setTag(R.id.obfuscated_res_0x7f090659, null);
            this.a.f14228g.setVisibility(8);
        }
    }

    @Override // c.a.p0.f1.l2.c.f.a
    public void k(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.a.f14223b.J(str, 10, false);
            this.a.f14224c.setText(str2);
        }
    }

    @Override // c.a.p0.f1.l2.c.f.a
    public void l(@NonNull LogicField logicField, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, logicField, i) == null) {
            TextView textView = C1068b.a[logicField.ordinal()] != 2 ? null : this.a.f14225d;
            if (textView != null) {
                textView.setVisibility(i);
            }
        }
    }

    @Override // c.a.p0.f1.l2.c.f.a
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.f14223b.setBorderWidth(n.f(this.f14218b, R.dimen.tbds1));
            this.a.f14223b.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
            this.a.f14223b.setStrokeColorResId(R.color.CAM_X0201);
            this.a.f14223b.setPlaceHolder(1);
            this.a.f14223b.invalidate();
            SkinManager.setViewTextColor(this.a.f14224c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.a.f14226e, (int) R.color.CAM_X0102);
        }
    }

    @NonNull
    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.a : (View) invokeV.objValue;
    }
}
