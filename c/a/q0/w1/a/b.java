package c.a.q0.w1.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import c.a.e.a.d;
import c.a.e.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends d<BubbleChooseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f27639a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f27640b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f27641c;

    /* renamed from: d  reason: collision with root package name */
    public View f27642d;

    /* renamed from: e  reason: collision with root package name */
    public a f27643e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f27644f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f27645g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f27644f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f27644f.findViewById(R.id.lay_title_bar);
        this.f27639a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f27639a.setTitleText(R.string.editor_privilege);
        this.f27642d = this.f27639a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f27644f);
        this.f27640b = (ViewGroup) this.f27644f.findViewById(R.id.container);
        this.f27641c = (GridView) this.f27644f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f27643e = aVar;
        this.f27641c.setAdapter((ListAdapter) aVar);
        this.f27645g = (ProgressBar) this.f27644f.findViewById(R.id.bubble_progress);
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27643e : (a) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27642d : (View) invokeV.objValue;
    }

    public GridView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27641c : (GridView) invokeV.objValue;
    }

    public BubbleListData.BubbleData f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            a aVar = this.f27643e;
            if (aVar == null) {
                return null;
            }
            return aVar.getItem(i2);
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f27645g.setVisibility(8);
        }
    }

    public void h(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, list, z) == null) || (aVar = this.f27643e) == null) {
            return;
        }
        aVar.d(z);
        this.f27643e.c(list);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f27645g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f27639a.onChangeSkinType((TbPageContext) getPageContext(), i2);
            this.f27644f.getLayoutMode().k(i2 == 1);
            this.f27644f.getLayoutMode().j(this.f27640b);
        }
    }
}
