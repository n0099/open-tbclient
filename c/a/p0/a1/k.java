package c.a.p0.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePurchasePackageData;
import com.baidu.tieba.faceshop.FacePurchaseRecordsActivity;
import com.baidu.tieba.faceshop.FacePurchaseRecordsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FacePurchaseRecordsActivity a;

    /* renamed from: b  reason: collision with root package name */
    public FacePurchaseRecordsData f11976b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11977c;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceShopActivityConfig(this.a.a.getPageContext().getContext(), CommonStatisticKey.FACESHOP_FROM_MORE)));
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f11978b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f11979c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f11980d;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(k kVar, a aVar) {
            this(kVar);
        }
    }

    public k(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {facePurchaseRecordsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11976b = null;
        this.a = facePurchaseRecordsActivity;
    }

    public final View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d016e, (ViewGroup) null);
            NoDataView a2 = NoDataViewFactory.a(this.a.getPageContext().getContext(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.EMOTION, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07024b)), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0345, R.string.obfuscated_res_0x7f0f07ab), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07aa), new a(this))));
            c.a.o0.r.c layoutMode = this.a.getLayoutMode();
            int skinType = TbadkApplication.getInst().getSkinType();
            if (layoutMode != null) {
                layoutMode.k(skinType == 1);
                layoutMode.j(inflate);
            }
            a2.f(this.a.getPageContext(), skinType);
            a2.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d028d, (ViewGroup) null);
            bVar.a = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090705);
            bVar.f11978b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09202b);
            bVar.f11979c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ffb);
            bVar.f11980d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918ea);
            inflate.setTag(bVar);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final void d(int i, b bVar) {
        FacePurchasePackageData facePurchasePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bVar) == null) || (facePurchasePackageData = (FacePurchasePackageData) getItem(i)) == null) {
            return;
        }
        bVar.a.setTag(facePurchasePackageData.cover_url);
        bVar.a.G(facePurchasePackageData.cover_url, 10, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070305), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070305), false);
        bVar.f11980d.setText(facePurchasePackageData.price);
        bVar.f11978b.setText(facePurchasePackageData.pname);
        Date date = new Date();
        date.setTime(facePurchasePackageData.puy_time * 1000);
        bVar.f11979c.setText(c.a.d.f.p.m.getDateStringDay(date));
    }

    public void e(FacePurchaseRecordsData facePurchaseRecordsData) {
        ArrayList<FacePurchasePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, facePurchaseRecordsData) == null) {
            if (facePurchaseRecordsData != null && (arrayList = facePurchaseRecordsData.buy_his) != null && arrayList.size() != 0) {
                this.f11977c = true;
            } else {
                this.f11977c = false;
            }
            this.f11976b = facePurchaseRecordsData;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        FacePurchaseRecordsData facePurchaseRecordsData;
        ArrayList<FacePurchasePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.f11977c || (facePurchaseRecordsData = this.f11976b) == null || (arrayList = facePurchaseRecordsData.buy_his) == null) {
                return 1;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        ArrayList<FacePurchasePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            FacePurchaseRecordsData facePurchaseRecordsData = this.f11976b;
            if (facePurchaseRecordsData == null || (arrayList = facePurchaseRecordsData.buy_his) == null || i < 0 || i >= arrayList.size()) {
                return null;
            }
            return arrayList.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (!this.f11977c) {
                return b();
            }
            if (view == null) {
                view = c();
            }
            b bVar = (b) view.getTag();
            c.a.o0.r.c layoutMode = this.a.getLayoutMode();
            layoutMode.k(skinType == 1);
            layoutMode.j(view);
            d(i, bVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
