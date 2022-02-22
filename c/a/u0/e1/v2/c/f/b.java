package c.a.u0.e1.v2.c.f;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.f1;
import c.a.u0.e1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b implements c.a.u0.e1.v2.c.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f17235b;

    /* renamed from: c  reason: collision with root package name */
    public String f17236c;

    /* renamed from: d  reason: collision with root package name */
    public String f17237d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17238e;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f17239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17240f;

        public a(b bVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17240f = bVar;
            this.f17239e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.s.j0.b.k().u("key_should_show_frs_new_tag", false);
                this.f17240f.a.f17245f.setVisibility(8);
                this.f17239e.onClick(view);
            }
        }
    }

    /* renamed from: c.a.u0.e1.v2.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1078b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1390203758, "Lc/a/u0/e1/v2/c/f/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1390203758, "Lc/a/u0/e1/v2/c/f/b$b;");
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

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f17241b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17242c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17243d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17244e;

        /* renamed from: f  reason: collision with root package name */
        public MessageRedDotView f17245f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f17246g;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                cVar.f17241b = (BarImageView) view.findViewById(f1.widget_frs_image);
                cVar.f17242c = (TextView) view.findViewById(f1.widget_forum_name);
                cVar.f17243d = (TextView) view.findViewById(f1.widget_brand_label);
                cVar.f17244e = (TextView) view.findViewById(f1.second_line_text);
                cVar.f17245f = (MessageRedDotView) view.findViewById(f1.new_tag);
                cVar.f17246g = (ImageView) view.findViewById(f1.widget_speed_icon);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17235b = view.getContext();
        c a2 = c.a(view);
        this.a = a2;
        a2.f17241b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.f17241b.setPageId(frsFragment.getUniqueId());
        this.a.f17241b.setContentDescription(view.getResources().getString(i1.bar_header));
        this.a.f17241b.setStrokeWith(n.f(TbadkCoreApplication.getInst(), d1.tbds4));
        this.a.f17241b.setShowOval(true);
        this.a.f17241b.setPlaceHolder(1);
        this.a.f17241b.setTag(f1.click_view_tag, LogicField.INFO_AREA);
        this.a.f17242c.setTag(f1.click_view_tag, LogicField.INFO_AREA);
        if (c.a.t0.s.j0.b.k().h("key_should_show_frs_new_tag", true)) {
            this.a.f17245f.setEnterForumStyle(true);
            this.a.f17245f.setFixMeasuredWidthHeight(true);
            this.a.f17245f.refresh(view.getResources().getString(i1.forum_new), false);
            this.a.f17245f.setVisibility(0);
        }
    }

    @Override // c.a.u0.e1.v2.c.f.a
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            if (C1078b.a[logicField.ordinal()] != 1) {
                return null;
            }
            return (T) this.a.f17246g;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.u0.e1.v2.c.f.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f17238e = z;
            this.a.f17244e.setText(z ? this.f17237d : this.f17236c);
            this.a.f17246g.setVisibility(z ? 0 : 8);
        }
    }

    @Override // c.a.u0.e1.v2.c.f.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            a aVar = new a(this, onClickListener);
            this.a.f17241b.setOnClickListener(aVar);
            this.a.f17242c.setOnClickListener(aVar);
            this.a.f17244e.setOnClickListener(onClickListener);
        }
    }

    @Override // c.a.u0.e1.v2.c.f.a
    public void g(int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            String format = String.format(this.f17235b.getString(i1.level_and_level_name), this.f17235b.getString(i1.lv_num, Integer.valueOf(i2)), str);
            this.f17237d = format;
            if (this.f17238e) {
                this.a.f17244e.setText(format);
                this.a.f17244e.setTag(f1.click_view_tag, LogicField.LEVEL_AND_LEVEL_NAME);
                this.a.f17246g.setVisibility(0);
            }
        }
    }

    @Override // c.a.u0.e1.v2.c.f.a
    public void j(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            String format = String.format(this.f17235b.getString(i1.attention_and_post), StringHelper.numberUniformFormatExtraWithRoundInt(j2), StringHelper.numberUniformFormatExtraWithRoundInt(j3));
            this.f17236c = format;
            if (this.f17238e) {
                return;
            }
            this.a.f17244e.setText(format);
            this.a.f17244e.setTag(f1.click_view_tag, null);
            this.a.f17246g.setVisibility(8);
        }
    }

    @Override // c.a.u0.e1.v2.c.f.a
    public void k(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.a.f17241b.startLoad(str, 10, false);
            this.a.f17242c.setText(str2);
        }
    }

    @Override // c.a.u0.e1.v2.c.f.a
    public void l(@NonNull LogicField logicField, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, logicField, i2) == null) {
            TextView textView = C1078b.a[logicField.ordinal()] != 2 ? null : this.a.f17243d;
            if (textView != null) {
                textView.setVisibility(i2);
            }
        }
    }

    @Override // c.a.u0.e1.v2.c.f.a
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.a.f17241b.setBorderWidth(n.f(this.f17235b, d1.tbds1));
            this.a.f17241b.setBorderColor(SkinManager.getColor(c1.CAM_X0603));
            this.a.f17241b.setStrokeColorResId(c1.CAM_X0201);
            this.a.f17241b.setPlaceHolder(1);
            this.a.f17241b.invalidate();
            SkinManager.setViewTextColor(this.a.f17242c, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.a.f17244e, c1.CAM_X0102);
        }
    }

    @NonNull
    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.a : (View) invokeV.objValue;
    }
}
