package b.a.l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class t extends a<b.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View j;
    public ThreadLinkView k;
    public TextView l;
    public b.a.q0.s.q.a m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().p != null && TbadkCoreApplication.getInst().getPersonalizeViewData().p.getParent() == null) {
            this.j = TbadkCoreApplication.getInst().getPersonalizeViewData().p;
        } else {
            this.j = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        }
        this.k = (ThreadLinkView) this.j.findViewById(R.id.link_thread_root);
        this.l = (TextView) this.j.findViewById(R.id.link_seg_title);
    }

    @Override // b.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    /* renamed from: n */
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar != null && aVar.getThreadData() != null) {
                this.m = aVar;
                d2 threadData = aVar.getThreadData();
                b.a.r0.b0.m.j(threadData, this.l);
                this.k.setData(threadData);
                return;
            }
            f().setVisibility(8);
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            this.k.onChangeSkinType();
            b.a.q0.s.q.a aVar = this.m;
            if (aVar == null || aVar.getThreadData() == null) {
                return;
            }
            b.a.r0.b0.m.l(this.l, this.m.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }
}
