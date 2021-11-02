package b.a.r0.v1;

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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BaseActivity<?> f24326e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f24327f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumSuggestModel.Forum> f24328g;

    /* renamed from: h  reason: collision with root package name */
    public String f24329h;

    /* renamed from: b.a.r0.v1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1189a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f24330a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24331b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f24332c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f24333d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f24334e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f24335f;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, C1189a c1189a) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24326e = baseActivity;
        this.f24327f = true;
        this.f24328g = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ForumSuggestModel.Forum getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int count = getCount();
            if (count <= 0 || i2 >= count) {
                return null;
            }
            return this.f24328g.get(i2);
        }
        return (ForumSuggestModel.Forum) invokeI.objValue;
    }

    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 >= 100000) {
                return String.valueOf(i2 / 10000) + this.f24326e.getPageContext().getString(R.string.member_count_unit);
            }
            return String.valueOf(i2);
        }
        return (String) invokeI.objValue;
    }

    public void c(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, str) == null) || textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f24329h)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f24329h.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f24329h.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(ArrayList<ForumSuggestModel.Forum> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f24328g = arrayList;
            if (arrayList != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f24329h = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<ForumSuggestModel.Forum> arrayList = this.f24328g;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f24326e.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
                bVar = new b(this, null);
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                bVar.f24332c = barImageView;
                barImageView.setGifIconSupport(false);
                bVar.f24331b = (TextView) view.findViewById(R.id.name);
                bVar.f24333d = (TextView) view.findViewById(R.id.forum_member_count);
                bVar.f24334e = (TextView) view.findViewById(R.id.forum_thread_count);
                bVar.f24335f = (TextView) view.findViewById(R.id.slogan);
                bVar.f24330a = view.findViewById(R.id.offical_icon);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            ForumSuggestModel.Forum item = getItem(i2);
            if (item == null) {
                return view;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            bVar.f24332c.setTag(str2);
            bVar.f24332c.startLoad(str2, 10, false);
            bVar.f24332c.invalidate();
            if (this.f24327f) {
                str = this.f24326e.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(bVar.f24331b, str);
            bVar.f24332c.setTag(item.avatar);
            TextView textView = bVar.f24333d;
            textView.setText(this.f24326e.getPageContext().getString(R.string.attention) + " " + b(item.member_num));
            TextView textView2 = bVar.f24334e;
            textView2.setText(this.f24326e.getPageContext().getString(R.string.text_post) + " " + b(item.thread_num));
            if (!this.f24327f && TextUtils.isEmpty(item.slogan)) {
                bVar.f24335f.setVisibility(8);
            } else {
                bVar.f24335f.setVisibility(0);
                bVar.f24335f.setText(item.slogan);
            }
            if (item.is_offical == 1) {
                bVar.f24330a.setVisibility(0);
                SkinManager.setBackgroundResource(bVar.f24330a, R.drawable.icon_search_official);
            } else {
                bVar.f24330a.setVisibility(8);
            }
            this.f24326e.getLayoutMode().k(skinType == 1);
            this.f24326e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
