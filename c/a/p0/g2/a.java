package c.a.p0.g2;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseActivity<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f15142b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ForumSuggestModel.Forum> f15143c;

    /* renamed from: d  reason: collision with root package name */
    public String f15144d;

    /* renamed from: c.a.p0.g2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C1141a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15145b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f15146c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15147d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15148e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f15149f;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, C1141a c1141a) {
            this(aVar);
        }
    }

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseActivity;
        this.f15142b = true;
        this.f15143c = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ForumSuggestModel.Forum getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int count = getCount();
            if (count <= 0 || i >= count) {
                return null;
            }
            return this.f15143c.get(i);
        }
        return (ForumSuggestModel.Forum) invokeI.objValue;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 100000) {
                return String.valueOf(i / 10000) + this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0aa2);
            }
            return String.valueOf(i);
        }
        return (String) invokeI.objValue;
    }

    public void c(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, str) == null) || textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f15144d)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f15144d.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f15144d.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(ArrayList<ForumSuggestModel.Forum> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f15143c = arrayList;
            if (arrayList != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f15144d = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<ForumSuggestModel.Forum> arrayList = this.f15143c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d079a, (ViewGroup) null);
                bVar = new b(this, null);
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090a1e);
                bVar.f15146c = barImageView;
                barImageView.setGifIconSupport(false);
                bVar.f15145b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0914e9);
                bVar.f15147d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a63);
                bVar.f15148e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a90);
                bVar.f15149f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091d31);
                bVar.a = view.findViewById(R.id.obfuscated_res_0x7f0915e2);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            ForumSuggestModel.Forum item = getItem(i);
            if (item == null) {
                return view;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            bVar.f15146c.setTag(str2);
            bVar.f15146c.J(str2, 10, false);
            bVar.f15146c.invalidate();
            if (this.f15142b) {
                str = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f03c0, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(bVar.f15145b, str);
            bVar.f15146c.setTag(item.avatar);
            TextView textView = bVar.f15147d;
            textView.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f029b) + " " + b(item.member_num));
            TextView textView2 = bVar.f15148e;
            textView2.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1385) + " " + b(item.thread_num));
            if (!this.f15142b && TextUtils.isEmpty(item.slogan)) {
                bVar.f15149f.setVisibility(8);
            } else {
                bVar.f15149f.setVisibility(0);
                bVar.f15149f.setText(item.slogan);
            }
            if (item.is_offical == 1) {
                bVar.a.setVisibility(0);
                SkinManager.setBackgroundResource(bVar.a, R.drawable.icon_search_official);
            } else {
                bVar.a.setVisibility(8);
            }
            this.a.getLayoutMode().k(skinType == 1);
            this.a.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
