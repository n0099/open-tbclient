package c.a.s0.n4.e0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.write.write.AtListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f20209e;

    /* renamed from: f  reason: collision with root package name */
    public AtListActivity f20210f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<MetaData> f20211g;

    /* renamed from: h  reason: collision with root package name */
    public TbCheckBox.b f20212h;

    /* renamed from: i  reason: collision with root package name */
    public c f20213i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f20214j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f20215k;

    /* renamed from: c.a.s0.n4.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1228a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f20216e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20217f;

        public View$OnClickListenerC1228a(a aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20217f = aVar;
            this.f20216e = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20217f.f20210f.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f20217f.f20210f.getPageContext().getPageActivity(), this.f20216e.getUserId(), this.f20216e.getUserName())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f20218b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f20219c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f20220d;

        /* renamed from: e  reason: collision with root package name */
        public TbCheckBox f20221e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f20222f;

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

        public /* synthetic */ b(a aVar, View$OnClickListenerC1228a view$OnClickListenerC1228a) {
            this(aVar);
        }
    }

    /* loaded from: classes7.dex */
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
        this.f20213i = null;
        this.f20214j = null;
        this.f20215k = true;
        this.f20210f = atListActivity;
        this.f20209e = atListActivity.getPageContext().getContext();
        this.f20215k = z;
    }

    public final b b(Object obj, MetaData metaData) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, metaData)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (obj == null) {
                bVar = c(metaData);
            } else {
                bVar = (b) obj;
            }
            bVar.f20218b.setOnClickListener(new View$OnClickListenerC1228a(this, metaData));
            c cVar = this.f20213i;
            if (cVar != null) {
                cVar.handlerItem(bVar.a, metaData);
            }
            String avater = metaData.getAvater();
            bVar.f20220d.setText(metaData.getName_show());
            if (metaData.getIsNearlyAt() == 1) {
                bVar.f20222f.setVisibility(0);
                bVar.f20222f.setText("最近@过");
            } else if (metaData.getIsFollower() == 1) {
                bVar.f20222f.setVisibility(0);
                bVar.f20222f.setText("互相关注");
            } else if (metaData.getIsMyFollower() == 1) {
                bVar.f20222f.setVisibility(0);
                bVar.f20222f.setText("我的关注");
            } else {
                bVar.f20222f.setVisibility(8);
            }
            bVar.f20221e.setTagData(metaData);
            bVar.f20219c.setTag(avater);
            if (this.f20215k) {
                bVar.f20221e.setVisibility(0);
            } else {
                bVar.f20221e.setVisibility(8);
            }
            bVar.f20219c.startLoad(avater, 12, false);
            UtilHelper.showHeadImageViewBigV(bVar.f20219c, metaData);
            this.f20210f.getPageContext().getLayoutMode().k(skinType == 1);
            this.f20210f.getPageContext().getLayoutMode().j(bVar.a);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b c(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.f20209e).inflate(c.a.s0.n4.h.invite_friend_list_item, (ViewGroup) null);
            bVar.a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(c.a.s0.n4.g.photo);
            bVar.f20219c = headImageView;
            headImageView.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(bVar.f20219c, metaData);
            bVar.f20218b = (LinearLayout) bVar.a.findViewById(c.a.s0.n4.g.photo_box);
            bVar.f20220d = (TextView) bVar.a.findViewById(c.a.s0.n4.g.txt_user_name);
            TextView textView = (TextView) bVar.a.findViewById(c.a.s0.n4.g.label_user);
            bVar.f20222f = textView;
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(textView);
            d2.v(c.a.s0.n4.d.CAM_X0108);
            d2.z(c.a.s0.n4.e.T_X10);
            d2.n(c.a.s0.n4.j.J_X04);
            d2.l(c.a.s0.n4.e.L_X01);
            d2.k(c.a.s0.n4.d.CAM_X0111);
            TbCheckBox tbCheckBox = (TbCheckBox) bVar.a.findViewById(c.a.s0.n4.g.ckb_select);
            bVar.f20221e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableIdIsWebP(true);
            bVar.f20221e.setBackgroundDrawableId(c.a.s0.n4.f.icon_pure_strok324_select, c.a.s0.n4.f.icon_pure_strok324);
            TbCheckBox.b bVar2 = this.f20212h;
            if (bVar2 != null) {
                bVar.f20221e.setStatedChangedListener(bVar2);
            }
            bVar.a.setTag(bVar);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public MetaData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            ArrayList<MetaData> arrayList = this.f20211g;
            if (arrayList != null && i2 < arrayList.size()) {
                return this.f20211g.get(i2);
            }
            return null;
        }
        return (MetaData) invokeI.objValue;
    }

    public void e(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f20212h = bVar;
        }
    }

    public void f(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f20211g = arrayList;
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f20213i = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<MetaData> arrayList = this.f20211g;
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
            if (this.f20214j == null) {
                this.f20214j = viewGroup;
            }
            MetaData item = getItem(i2);
            if (item != null) {
                bVar = b(view != null ? view.getTag() : null, item);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                return bVar.a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
