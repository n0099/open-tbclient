package c.a.e0.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<InstallmentEntity> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f2868b;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f2869b;

        /* renamed from: c  reason: collision with root package name */
        public View f2870c;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2870c = view.findViewById(R.id.obfuscated_res_0x7f091764);
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091768);
            this.f2869b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091767);
        }
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2868b = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public InstallmentEntity getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (InstallmentEntity) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<InstallmentEntity> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
            InstallmentEntity item = getItem(i);
            if (item == null) {
                return view;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f2868b).inflate(R.layout.obfuscated_res_0x7f0d06ab, (ViewGroup) null, false);
                view.setTag(new a(view));
            }
            if (view.getTag() != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                aVar.a.setText(item.getTitle());
                aVar.f2869b.setText(item.getPayText());
                if (item.isChecked()) {
                    aVar.a.setTextSize(1, 14.0f);
                    aVar.a.setTextColor(this.f2868b.getResources().getColor(R.color.obfuscated_res_0x7f0608ac));
                    aVar.f2869b.setTextSize(1, 10.0f);
                    aVar.f2869b.setTextColor(this.f2868b.getResources().getColor(R.color.obfuscated_res_0x7f0608ac));
                    aVar.f2870c.setBackground(this.f2868b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080eb9));
                } else {
                    aVar.a.setTextSize(1, 14.0f);
                    aVar.a.setTextColor(this.f2868b.getResources().getColor(R.color.obfuscated_res_0x7f060aba));
                    aVar.f2869b.setTextSize(1, 10.0f);
                    aVar.f2869b.setTextColor(this.f2868b.getResources().getColor(R.color.obfuscated_res_0x7f0608ad));
                    aVar.f2870c.setBackground(this.f2868b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080eb8));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
