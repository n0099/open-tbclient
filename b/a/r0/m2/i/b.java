package b.a.r0.m2.i;

import android.os.Bundle;
import b.a.e.m.e.n;
import b.a.r0.b0.d0;
import b.a.r0.n2.e.h;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f22355a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f22356b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f22357c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f22358d;

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
        this.f22356b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.f22355a = cVar;
        cVar.f(d0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f22358d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22357c = new ArrayList();
            PersonMoreData personMoreData = this.f22358d;
            if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
                return;
            }
            for (PersonMoreItemData personMoreItemData : this.f22358d.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.f22955i = personMoreItemData.mName;
                    hVar.f22951e = 36;
                    hVar.k = personMoreItemData.mUrl;
                    hVar.o = personMoreItemData.mId;
                    this.f22357c.add(hVar);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22356b.getPageActivity().setContentView(R.layout.person_center_more_layout);
            this.f22355a.c(this.f22356b.getPageActivity().findViewById(R.id.person_more_layout));
            a();
            this.f22355a.e(this.f22357c);
        }
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f22355a) == null) {
            return;
        }
        cVar.d();
    }
}
