package c.a.r0.s2.i;

import android.os.Bundle;
import c.a.d.m.e.n;
import c.a.r0.g0.d0;
import c.a.r0.t2.e.h;
import c.a.r0.w2.d;
import c.a.r0.w2.e;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f23500b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f23501c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f23502d;

    public b(TbPageContext tbPageContext, Bundle bundle, d0<h> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, d0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23500b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.a = cVar;
        cVar.f(d0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f23502d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23501c = new ArrayList();
            PersonMoreData personMoreData = this.f23502d;
            if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
                return;
            }
            for (PersonMoreItemData personMoreItemData : this.f23502d.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.f23708i = personMoreItemData.mName;
                    hVar.f23704e = 36;
                    hVar.f23710k = personMoreItemData.mUrl;
                    hVar.o = personMoreItemData.mId;
                    this.f23501c.add(hVar);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23500b.getPageActivity().setContentView(e.person_center_more_layout);
            this.a.c(this.f23500b.getPageActivity().findViewById(d.person_more_layout));
            a();
            this.a.e(this.f23501c);
        }
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.a) == null) {
            return;
        }
        cVar.d();
    }
}
