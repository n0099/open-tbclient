package c.a.p0.j2.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.p0.j2.c.b.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<r> a;

    /* renamed from: b  reason: collision with root package name */
    public MemberTaskCenterActivity f15692b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f15693c;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15694b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15695c;

        /* renamed from: d  reason: collision with root package name */
        public View f15696d;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberTaskCenterActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f15692b = memberTaskCenterActivity;
    }

    public final SpannableString a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SpannableString spannableString = new SpannableString(str + str2);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), str.length(), spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public r getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<r> list = this.a;
            if (list == null || list.size() <= i) {
                return null;
            }
            return this.a.get(i);
        }
        return (r) invokeI.objValue;
    }

    public void c(List<r> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a.clear();
            if (list != null) {
                this.a.addAll(list);
            }
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f15693c = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<r> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15692b.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d054a, (ViewGroup) null);
                aVar = new a(this);
                aVar.f15694b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091ef5);
                aVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091ef6);
                aVar.f15695c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091ef7);
                aVar.f15696d = view.findViewById(R.id.obfuscated_res_0x7f0907f4);
            }
            r item = getItem(i);
            if (item != null) {
                aVar.a.setText(item.f());
                aVar.f15694b.setText(a(String.valueOf(item.a()), item.b()));
                if (item.d()) {
                    aVar.f15695c.setText(this.f15692b.getPageContext().getString(R.string.obfuscated_res_0x7f0f08d2), TextView.BufferType.EDITABLE);
                    aVar.f15695c.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                    aVar.f15695c.setBackgroundDrawable(null);
                    aVar.f15695c.setOnClickListener(null);
                } else {
                    aVar.f15695c.setText(this.f15692b.getPageContext().getString(R.string.obfuscated_res_0x7f0f0478), TextView.BufferType.EDITABLE);
                    SkinManager.setViewTextColor(aVar.f15695c, (int) R.color.member_center_task_btn_textcolor);
                    aVar.f15695c.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.item_blue_btn_selector));
                    aVar.f15695c.setTag(item);
                    aVar.f15695c.setOnClickListener(this.f15693c);
                }
                SkinManager.setViewTextColor(aVar.f15694b, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(aVar.a, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundColor(aVar.f15696d, R.color.CAM_X0204);
            }
            view.setTag(aVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
