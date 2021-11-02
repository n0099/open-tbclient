package b.a.r0.v1.h;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f24350e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f24351f;

    /* renamed from: g  reason: collision with root package name */
    public Context f24352g;

    /* renamed from: b.a.r0.v1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1190a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public a(Context context, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24352g = context;
        this.f24351f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int count = getCount();
            if (count <= 0 || i2 >= count) {
                return null;
            }
            return this.f24351f.get(i2);
        }
        return (String) invokeI.objValue;
    }

    public void b(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, str) == null) || textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f24350e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f24350e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f24350e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f24351f = list;
            if (list != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f24350e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<String> list = this.f24351f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f24352g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
                bVar = new b(this, null);
                bVar.f24354b = view.findViewById(R.id.rootview);
                bVar.f24355c = (TextView) view.findViewById(R.id.searchSuggestTitle);
                bVar.f24356d = view.findViewById(R.id.searchItemSep);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            String item = getItem(i2);
            if (StringUtils.isNull(item)) {
                return view;
            }
            b(bVar.f24355c, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != bVar.f24353a) {
                bVar.f24353a = skinType;
                SkinManager.setBackgroundResource(bVar.f24354b, R.drawable.addresslist_item_bg);
                SkinManager.setViewTextColor(bVar.f24355c, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(bVar.f24356d, R.color.CAM_X0204);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f24353a;

        /* renamed from: b  reason: collision with root package name */
        public View f24354b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f24355c;

        /* renamed from: d  reason: collision with root package name */
        public View f24356d;

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
                    return;
                }
            }
            this.f24353a = 3;
        }

        public /* synthetic */ b(a aVar, C1190a c1190a) {
            this(aVar);
        }
    }
}
