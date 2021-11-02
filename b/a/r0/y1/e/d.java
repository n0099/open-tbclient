package b.a.r0.y1.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import b.a.r0.y1.c.k.r;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NoNetworkView f27517a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f27518b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f27519c;

    /* renamed from: d  reason: collision with root package name */
    public View f27520d;

    /* renamed from: e  reason: collision with root package name */
    public b f27521e;

    /* renamed from: f  reason: collision with root package name */
    public View f27522f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f27523g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27524h;

    /* renamed from: i  reason: collision with root package name */
    public MemberTaskCenterActivity f27525i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberTaskCenterActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27525i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f27520d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f27517a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f27518b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f27518b.setTitleText(R.string.member_task_center);
        this.f27519c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f27522f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f27519c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f27522f.findViewById(R.id.advert_image_view);
        this.f27523g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f27524h = (TextView) this.f27522f.findViewById(R.id.current_score_num);
        this.f27523g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f27521e = bVar;
        bVar.d(onClickListener);
        this.f27519c.addHeaderView(this.f27522f);
        this.f27519c.setAdapter((ListAdapter) this.f27521e);
    }

    public final SpannableString a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SpannableString spannableString = new SpannableString(str + str2);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public BdListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27519c : (BdListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27520d : (View) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f27518b.onChangeSkinType(this.f27525i.getPageContext(), i2);
            this.f27517a.onChangeSkinType(this.f27525i.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f27524h, R.color.CAM_X0205);
        }
    }

    public void e(String str, List<r> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, list, Long.valueOf(j)}) == null) {
            this.f27523g.startLoad(str, 10, false);
            this.f27524h.setText(a(this.f27525i.getResources().getString(R.string.current_score), String.valueOf(j)));
            this.f27521e.c(list);
            this.f27521e.notifyDataSetChanged();
        }
    }
}
