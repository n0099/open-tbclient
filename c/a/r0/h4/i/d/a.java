package c.a.r0.h4.i.d;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.h4.i.d.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.h4.i.e.a f17953b;

    /* renamed from: c  reason: collision with root package name */
    public b f17954c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f17955d;

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
        this.a = context;
    }

    public static void a(List<c.a.r0.h4.i.e.a> list, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65537, null, list, i2, str, str2) == null) || list == null) {
            return;
        }
        list.add(new c.a.r0.h4.i.e.a(str, i2, str2));
    }

    public static List<c.a.r0.h4.i.e.a> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.filter_icon_avatar_default, context.getString(R.string.filter_nature), FilterValue.DEFAULT_FILTER_VALUE);
            a(arrayList, R.drawable.filter_icon_avatar_hongkong, context.getString(R.string.filter_hongkong), "hongkong");
            a(arrayList, R.drawable.filter_icon_avatar_refreshing, context.getString(R.string.filter_refreshing), "refreshing");
            a(arrayList, R.drawable.filter_icon_avatar_girly, context.getString(R.string.filter_girly), "girly");
            a(arrayList, R.drawable.filter_icon_avatar_concrete, context.getString(R.string.filter_concrete), "concrete");
            a(arrayList, R.drawable.filter_icon_avatar_warm, context.getString(R.string.filter_warm), "warm");
            a(arrayList, R.drawable.filter_icon_avatar_cold, context.getString(R.string.filter_cold), "cold");
            a(arrayList, R.drawable.filter_icon_avatar_japanese, context.getString(R.string.filter_japanese), "Japanese");
            a(arrayList, R.drawable.filter_icon_avatar_cruz, context.getString(R.string.filter_hdr), "cruz");
            a(arrayList, R.drawable.filter_icon_avatar_abao, context.getString(R.string.filter_abao), "abao");
            a(arrayList, R.drawable.filter_icon_avatar_dew, context.getString(R.string.filter_dew), "dew");
            a(arrayList, R.drawable.filter_icon_avatar_slowlived, context.getString(R.string.filter_slowlived), "slowlived");
            a(arrayList, R.drawable.filter_icon_avatar_sweet, context.getString(R.string.filter_sweet), "sweet");
            a(arrayList, R.drawable.filter_icon_avatar_boardwalk, context.getString(R.string.filter_boardwalk), "boardwalk");
            a(arrayList, R.drawable.filter_icon_avatar_keylime, context.getString(R.string.filter_keylime), "keylime");
            a(arrayList, R.drawable.filter_icon_avatar_electric, context.getString(R.string.filter_electric), "electric");
            a(arrayList, R.drawable.filter_icon_avatar_silver, context.getString(R.string.filter_silver), "silver");
            a(arrayList, R.drawable.filter_icon_avatar_blackwhite, context.getString(R.string.filter_blackwhite), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c.a.r0.h4.c.f17912f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + ".mp4";
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.r0.h4.i.e.a aVar = this.f17953b;
            return (aVar == null || "normal".equalsIgnoreCase(aVar.f17997c)) ? "" : this.f17953b.f17997c;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f17954c) == null) {
            return;
        }
        bVar.e();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.f17954c;
            if (bVar != null) {
                return bVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            b bVar = this.f17954c;
            if ((bVar == null || !bVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                b bVar2 = new b(this.a, str, d(), str2);
                this.f17954c = bVar2;
                b.c cVar = this.f17955d;
                if (cVar != null) {
                    bVar2.h(cVar);
                }
                this.f17954c.i();
            }
        }
    }

    public void h(c.a.r0.h4.i.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f17953b = aVar;
        }
    }

    public void i(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f17955d = cVar;
            b bVar = this.f17954c;
            if (bVar != null) {
                bVar.h(cVar);
            }
        }
    }
}
