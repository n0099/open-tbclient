package c.a.q0.a1.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import c.a.d.a.j;
import c.a.q0.a1.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends c.a.q0.f0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoDataView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(new NoDataView(context));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (NoDataView) getView();
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.a.onChangeSkinType(j.a(getView().getContext()), i2);
        }
    }

    public void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.setVisibility(0);
        NoDataViewFactory.d.a aVar2 = new NoDataViewFactory.d.a();
        aVar2.i(NoDataViewFactory.ImgType.LOCAL);
        aVar2.h(aVar.f12036c);
        aVar2.j(aVar.f12040g);
        this.a.setImgOption(aVar2.f());
        String str = (!aVar.f12035b || TextUtils.isEmpty(aVar.a)) ? aVar.f12037d : aVar.a;
        NoDataViewFactory.e.a aVar3 = new NoDataViewFactory.e.a();
        aVar3.g(str);
        this.a.setTextOption(aVar3.f());
        if (aVar.f12039f && !TextUtils.isEmpty(aVar.f12038e)) {
            String str2 = aVar.f12038e;
            View.OnClickListener onClickListener = aVar.f12041h;
            NoDataViewFactory.c.a aVar4 = new NoDataViewFactory.c.a();
            aVar4.f(new NoDataViewFactory.b(str2, onClickListener));
            this.a.setButtonOption(aVar4.e());
        } else {
            this.a.setButtonOption(null);
        }
        a(TbadkCoreApplication.getInst().getSkinType());
    }
}
