package c.a.r0.x1.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.r0.x1.c.k.r;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NoNetworkView f28619a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f28620b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f28621c;

    /* renamed from: d  reason: collision with root package name */
    public View f28622d;

    /* renamed from: e  reason: collision with root package name */
    public b f28623e;

    /* renamed from: f  reason: collision with root package name */
    public View f28624f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f28625g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f28626h;

    /* renamed from: i  reason: collision with root package name */
    public MemberTaskCenterActivity f28627i;

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
        this.f28627i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f28622d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f28619a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f28620b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f28620b.setTitleText(R.string.member_task_center);
        this.f28621c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f28624f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f28621c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f28624f.findViewById(R.id.advert_image_view);
        this.f28625g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f28626h = (TextView) this.f28624f.findViewById(R.id.current_score_num);
        this.f28625g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f28623e = bVar;
        bVar.d(onClickListener);
        this.f28621c.addHeaderView(this.f28624f);
        this.f28621c.setAdapter((ListAdapter) this.f28623e);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28621c : (BdListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28622d : (View) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f28620b.onChangeSkinType(this.f28627i.getPageContext(), i2);
            this.f28619a.onChangeSkinType(this.f28627i.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f28626h, R.color.CAM_X0205);
        }
    }

    public void e(String str, List<r> list, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, list, Long.valueOf(j2)}) == null) {
            this.f28625g.startLoad(str, 10, false);
            this.f28626h.setText(a(this.f28627i.getResources().getString(R.string.current_score), String.valueOf(j2)));
            this.f28623e.c(list);
            this.f28623e.notifyDataSetChanged();
        }
    }
}
