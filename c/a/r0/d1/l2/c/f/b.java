package c.a.r0.d1.l2.c.f;

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
public class b implements c.a.r0.d1.l2.c.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f15817b;

    /* renamed from: c  reason: collision with root package name */
    public String f15818c;

    /* renamed from: d  reason: collision with root package name */
    public String f15819d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15820e;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f15821e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f15822f;

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
            this.f15822f = bVar;
            this.f15821e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.r.j0.b.k().u("key_should_show_frs_new_tag", false);
                this.f15822f.a.f15827f.setVisibility(8);
                this.f15821e.onClick(view);
            }
        }
    }

    /* renamed from: c.a.r0.d1.l2.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C1009b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1374522302, "Lc/a/r0/d1/l2/c/f/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1374522302, "Lc/a/r0/d1/l2/c/f/b$b;");
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
        public BarImageView f15823b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15824c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15825d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15826e;

        /* renamed from: f  reason: collision with root package name */
        public MessageRedDotView f15827f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f15828g;

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
                cVar.f15823b = (BarImageView) view.findViewById(R.id.widget_frs_image);
                cVar.f15824c = (TextView) view.findViewById(R.id.widget_forum_name);
                cVar.f15825d = (TextView) view.findViewById(R.id.widget_brand_label);
                cVar.f15826e = (TextView) view.findViewById(R.id.second_line_text);
                cVar.f15827f = (MessageRedDotView) view.findViewById(R.id.new_tag);
                cVar.f15828g = (ImageView) view.findViewById(R.id.widget_speed_icon);
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
        this.f15817b = view.getContext();
        c a2 = c.a(view);
        this.a = a2;
        a2.f15823b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.f15823b.setPageId(frsFragment.getUniqueId());
        this.a.f15823b.setContentDescription(view.getResources().getString(R.string.bar_header));
        this.a.f15823b.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.a.f15823b.setShowOval(true);
        this.a.f15823b.setPlaceHolder(1);
        this.a.f15823b.setTag(R.id.click_view_tag, LogicField.INFO_AREA);
        this.a.f15824c.setTag(R.id.click_view_tag, LogicField.INFO_AREA);
        if (c.a.q0.r.j0.b.k().h("key_should_show_frs_new_tag", true)) {
            this.a.f15827f.setEnterForumStyle(true);
            this.a.f15827f.setFixMeasuredWidthHeight(true);
            this.a.f15827f.refresh(view.getResources().getString(R.string.forum_new), false);
            this.a.f15827f.setVisibility(0);
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            if (C1009b.a[logicField.ordinal()] != 1) {
                return null;
            }
            return (T) this.a.f15828g;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f15820e = z;
            this.a.f15826e.setText(z ? this.f15819d : this.f15818c);
            this.a.f15828g.setVisibility(z ? 0 : 8);
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            a aVar = new a(this, onClickListener);
            this.a.f15823b.setOnClickListener(aVar);
            this.a.f15824c.setOnClickListener(aVar);
            this.a.f15826e.setOnClickListener(onClickListener);
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void g(int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            String format = String.format(this.f15817b.getString(R.string.level_and_level_name), this.f15817b.getString(R.string.lv_num, Integer.valueOf(i2)), str);
            this.f15819d = format;
            if (this.f15820e) {
                this.a.f15826e.setText(format);
                this.a.f15826e.setTag(R.id.click_view_tag, LogicField.LEVEL_AND_LEVEL_NAME);
                this.a.f15828g.setVisibility(0);
            }
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void j(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            String format = String.format(this.f15817b.getString(R.string.attention_and_post), StringHelper.numberUniformFormatExtraWithRoundInt(j2), StringHelper.numberUniformFormatExtraWithRoundInt(j3));
            this.f15818c = format;
            if (this.f15820e) {
                return;
            }
            this.a.f15826e.setText(format);
            this.a.f15826e.setTag(R.id.click_view_tag, null);
            this.a.f15828g.setVisibility(8);
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void k(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.a.f15823b.startLoad(str, 10, false);
            this.a.f15824c.setText(str2);
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void l(@NonNull LogicField logicField, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, logicField, i2) == null) {
            TextView textView = C1009b.a[logicField.ordinal()] != 2 ? null : this.a.f15825d;
            if (textView != null) {
                textView.setVisibility(i2);
            }
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.a.f15823b.setBorderWidth(n.f(this.f15817b, R.dimen.tbds1));
            this.a.f15823b.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
            this.a.f15823b.setStrokeColorResId(R.color.CAM_X0201);
            this.a.f15823b.setPlaceHolder(1);
            this.a.f15823b.invalidate();
            SkinManager.setViewTextColor(this.a.f15824c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.a.f15826e, (int) R.color.CAM_X0102);
        }
    }

    @NonNull
    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.a : (View) invokeV.objValue;
    }
}
