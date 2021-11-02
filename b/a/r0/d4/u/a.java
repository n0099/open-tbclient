package b.a.r0.d4.u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f16072e;

    /* renamed from: f  reason: collision with root package name */
    public AtListActivity f16073f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<MetaData> f16074g;

    /* renamed from: h  reason: collision with root package name */
    public TbCheckBox.b f16075h;

    /* renamed from: i  reason: collision with root package name */
    public c f16076i;
    public ViewGroup j;
    public boolean k;

    /* renamed from: b.a.r0.d4.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C0819a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f16077a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f16078b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16079c;

        /* renamed from: d  reason: collision with root package name */
        public TbCheckBox f16080d;

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

        public /* synthetic */ b(a aVar, C0819a c0819a) {
            this(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void handlerItem(View view, MetaData metaData);
    }

    public a(AtListActivity atListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16076i = null;
        this.j = null;
        this.k = true;
        this.f16073f = atListActivity;
        this.f16072e = atListActivity.getPageContext().getContext();
        this.k = z;
    }

    public final b a(Object obj, MetaData metaData) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, metaData)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (obj == null) {
                bVar = b(metaData);
            } else {
                bVar = (b) obj;
            }
            c cVar = this.f16076i;
            if (cVar != null) {
                cVar.handlerItem(bVar.f16077a, metaData);
            }
            String avater = metaData.getAvater();
            bVar.f16079c.setText(metaData.getName_show());
            bVar.f16080d.setTagData(metaData);
            bVar.f16078b.setTag(avater);
            if (this.k) {
                bVar.f16080d.setVisibility(0);
            } else {
                bVar.f16080d.setVisibility(8);
            }
            bVar.f16078b.startLoad(avater, 12, false);
            UtilHelper.showHeadImageViewBigV(bVar.f16078b, metaData);
            this.f16073f.getPageContext().getLayoutMode().k(skinType == 1);
            this.f16073f.getPageContext().getLayoutMode().j(bVar.f16077a);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b b(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.f16072e).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
            bVar.f16077a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.photo);
            bVar.f16078b = headImageView;
            headImageView.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(bVar.f16078b, metaData);
            bVar.f16079c = (TextView) bVar.f16077a.findViewById(R.id.txt_user_name);
            TbCheckBox tbCheckBox = (TbCheckBox) bVar.f16077a.findViewById(R.id.ckb_select);
            bVar.f16080d = tbCheckBox;
            tbCheckBox.setBackgroundDrawableIdIsWebP(true);
            bVar.f16080d.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
            TbCheckBox.b bVar2 = this.f16075h;
            if (bVar2 != null) {
                bVar.f16080d.setStatedChangedListener(bVar2);
            }
            bVar.f16077a.setTag(bVar);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public MetaData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            ArrayList<MetaData> arrayList = this.f16074g;
            if (arrayList != null && i2 < arrayList.size()) {
                return this.f16074g.get(i2);
            }
            return null;
        }
        return (MetaData) invokeI.objValue;
    }

    public void d(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f16075h = bVar;
        }
    }

    public void e(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f16074g = arrayList;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f16076i = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<MetaData> arrayList = this.f16074g;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            if (this.j == null) {
                this.j = viewGroup;
            }
            MetaData item = getItem(i2);
            if (item != null) {
                bVar = a(view != null ? view.getTag() : null, item);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                return bVar.f16077a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
