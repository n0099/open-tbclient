package c.a.s0.o2.g;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.s0.o2.c.b> f21366b;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21366b = new ArrayList();
        this.a = context;
        a();
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return R.drawable.icon_mask_guide_game;
                case 2:
                    return R.drawable.icon_mask_guide_life;
                case 3:
                    return R.drawable.icon_mask_guide_comic;
                case 4:
                    return R.drawable.icon_mask_guide_literatue;
                case 5:
                    return R.drawable.icon_mask_guide_science;
                case 6:
                    return R.drawable.icon_mask_guide_leaf;
                case 7:
                    return R.drawable.icon_mask_guide_star;
                case 8:
                    return R.drawable.icon_mask_guide_motion;
                case 9:
                    return R.drawable.icon_mask_guide_sport;
                case 10:
                case 15:
                case 17:
                case 18:
                case 21:
                default:
                    return -1;
                case 11:
                    return R.drawable.icon_mask_guide_movie;
                case 12:
                    return R.drawable.icon_mask_guide_education;
                case 13:
                    return R.drawable.icon_mask_guide_trail;
                case 14:
                    return R.drawable.icon_mask_guide_art;
                case 16:
                    return R.drawable.icon_mask_guide_food;
                case 19:
                    return R.drawable.icon_mask_guide_funny;
                case 20:
                    return R.drawable.icon_mask_guide_car;
                case 22:
                    return R.drawable.icon_mask_guide_digital;
                case 23:
                    return R.drawable.icon_mask_guide_fasion;
                case 24:
                    return R.drawable.icon_mask_guide_music;
                case 25:
                    return R.drawable.icon_mask_guide_constellation;
                case 26:
                    return R.drawable.icon_mask_guide_history;
                case 27:
                    return R.drawable.icon_mask_guide_military;
                case 28:
                    return R.drawable.icon_mask_guide_tieba;
            }
        }
        return invokeI.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21366b.add(new c.a.s0.o2.c.b(1, this.a.getString(R.string.interested_class_name_game), R.drawable.icon_mask_guide_game, false));
            this.f21366b.add(new c.a.s0.o2.c.b(3, this.a.getString(R.string.interested_class_name_comic), R.drawable.icon_mask_guide_comic, false));
            this.f21366b.add(new c.a.s0.o2.c.b(11, this.a.getString(R.string.interested_class_name_movie), R.drawable.icon_mask_guide_movie, false));
            this.f21366b.add(new c.a.s0.o2.c.b(4, this.a.getString(R.string.interested_class_name_literatue), R.drawable.icon_mask_guide_literatue, false));
            this.f21366b.add(new c.a.s0.o2.c.b(22, this.a.getString(R.string.interested_class_name_digita), R.drawable.icon_mask_guide_digital, false));
            this.f21366b.add(new c.a.s0.o2.c.b(5, this.a.getString(R.string.interested_class_name_science), R.drawable.icon_mask_guide_science, false));
            this.f21366b.add(new c.a.s0.o2.c.b(19, this.a.getString(R.string.interested_class_name_funny), R.drawable.icon_mask_guide_funny, false));
            this.f21366b.add(new c.a.s0.o2.c.b(8, this.a.getString(R.string.interested_class_name_motion), R.drawable.icon_mask_guide_motion, false));
            this.f21366b.add(new c.a.s0.o2.c.b(2, this.a.getString(R.string.interested_class_name_life), R.drawable.icon_mask_guide_life, false));
            this.f21366b.add(new c.a.s0.o2.c.b(16, this.a.getString(R.string.interested_class_name_food), R.drawable.icon_mask_guide_food, false));
            this.f21366b.add(new c.a.s0.o2.c.b(13, this.a.getString(R.string.interested_class_name_trail), R.drawable.icon_mask_guide_trail, false));
            this.f21366b.add(new c.a.s0.o2.c.b(12, this.a.getString(R.string.interested_class_name_education), R.drawable.icon_mask_guide_education, false));
            this.f21366b.add(new c.a.s0.o2.c.b(23, this.a.getString(R.string.interested_class_name_fasion), R.drawable.icon_mask_guide_fasion, false));
            this.f21366b.add(new c.a.s0.o2.c.b(14, this.a.getString(R.string.interested_class_name_art), R.drawable.icon_mask_guide_art, false));
            this.f21366b.add(new c.a.s0.o2.c.b(20, this.a.getString(R.string.interested_class_name_car), R.drawable.icon_mask_guide_car, false));
            this.f21366b.add(new c.a.s0.o2.c.b(7, this.a.getString(R.string.interested_class_name_star), R.drawable.icon_mask_guide_star, false));
            this.f21366b.add(new c.a.s0.o2.c.b(9, this.a.getString(R.string.interested_class_name_sport), R.drawable.icon_mask_guide_sport, false));
            this.f21366b.add(new c.a.s0.o2.c.b(6, this.a.getString(R.string.interested_class_name_leaf), R.drawable.icon_mask_guide_leaf, false));
            this.f21366b.add(new c.a.s0.o2.c.b(24, this.a.getString(R.string.interested_class_name_music), R.drawable.icon_mask_guide_music, false));
            this.f21366b.add(new c.a.s0.o2.c.b(25, this.a.getString(R.string.interested_class_name_constellation), R.drawable.icon_mask_guide_constellation, false));
            this.f21366b.add(new c.a.s0.o2.c.b(26, this.a.getString(R.string.interested_class_name_history), R.drawable.icon_mask_guide_history, false));
            this.f21366b.add(new c.a.s0.o2.c.b(27, this.a.getString(R.string.interested_class_name_military), R.drawable.icon_mask_guide_military, false));
            this.f21366b.add(new c.a.s0.o2.c.b(28, this.a.getString(R.string.interested_class_name_tieba), R.drawable.icon_mask_guide_tieba, false));
        }
    }

    public List<c.a.s0.o2.c.b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21366b : (List) invokeV.objValue;
    }
}
