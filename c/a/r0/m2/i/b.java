package c.a.r0.m2.i;

import android.os.Bundle;
import c.a.e.l.e.n;
import c.a.r0.b0.c0;
import c.a.r0.n2.e.h;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f22293a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f22294b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f22295c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f22296d;

    public b(TbPageContext tbPageContext, Bundle bundle, c0<h> c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, c0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22294b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.f22293a = cVar;
        cVar.f(c0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f22296d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22295c = new ArrayList();
            PersonMoreData personMoreData = this.f22296d;
            if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
                return;
            }
            for (PersonMoreItemData personMoreItemData : this.f22296d.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.f22562i = personMoreItemData.mName;
                    hVar.f22558e = 36;
                    hVar.k = personMoreItemData.mUrl;
                    hVar.o = personMoreItemData.mId;
                    this.f22295c.add(hVar);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22294b.getPageActivity().setContentView(R.layout.person_center_more_layout);
            this.f22293a.c(this.f22294b.getPageActivity().findViewById(R.id.person_more_layout));
            a();
            this.f22293a.e(this.f22295c);
        }
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f22293a) == null) {
            return;
        }
        cVar.d();
    }
}
