package c.a.p0.j2.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.p0.j2.c.b.r;
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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoNetworkView a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f15701b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f15702c;

    /* renamed from: d  reason: collision with root package name */
    public View f15703d;

    /* renamed from: e  reason: collision with root package name */
    public b f15704e;

    /* renamed from: f  reason: collision with root package name */
    public View f15705f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15706g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15707h;
    public MemberTaskCenterActivity i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberTaskCenterActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.obfuscated_res_0x7f0d0548);
        this.f15703d = memberTaskCenterActivity.findViewById(R.id.obfuscated_res_0x7f091aee);
        this.a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.obfuscated_res_0x7f0923d1);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15701b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15701b.setTitleText(R.string.obfuscated_res_0x7f0f0ab1);
        this.f15702c = (BdListView) memberTaskCenterActivity.findViewById(R.id.obfuscated_res_0x7f0913e4);
        this.f15705f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0549, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f15702c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f15705f.findViewById(R.id.obfuscated_res_0x7f090147);
        this.f15706g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f15707h = (TextView) this.f15705f.findViewById(R.id.obfuscated_res_0x7f090735);
        this.f15706g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f15704e = bVar;
        bVar.d(onClickListener);
        this.f15702c.addHeaderView(this.f15705f);
        this.f15702c.setAdapter((ListAdapter) this.f15704e);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15702c : (BdListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15703d : (View) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f15701b.onChangeSkinType(this.i.getPageContext(), i);
            this.a.c(this.i.getPageContext(), i);
            SkinManager.setBackgroundColor(this.f15707h, R.color.CAM_X0205);
        }
    }

    public void e(String str, List<r> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, list, Long.valueOf(j)}) == null) {
            this.f15706g.J(str, 10, false);
            this.f15707h.setText(a(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f0463), String.valueOf(j)));
            this.f15704e.c(list);
            this.f15704e.notifyDataSetChanged();
        }
    }
}
