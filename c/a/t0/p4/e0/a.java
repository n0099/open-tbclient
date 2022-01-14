package c.a.t0.p4.e0;

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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f21093e;

    /* renamed from: f  reason: collision with root package name */
    public AtListActivity f21094f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<MetaData> f21095g;

    /* renamed from: h  reason: collision with root package name */
    public TbCheckBox.b f21096h;

    /* renamed from: i  reason: collision with root package name */
    public c f21097i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f21098j;
    public boolean k;

    /* renamed from: c.a.t0.p4.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1322a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f21099e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f21100f;

        public View$OnClickListenerC1322a(a aVar, MetaData metaData) {
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
            this.f21100f = aVar;
            this.f21099e = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21100f.f21094f.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f21100f.f21094f.getPageContext().getPageActivity(), this.f21099e.getUserId(), this.f21099e.getUserName())));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f21101b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f21102c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f21103d;

        /* renamed from: e  reason: collision with root package name */
        public TbCheckBox f21104e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f21105f;

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

        public /* synthetic */ b(a aVar, View$OnClickListenerC1322a view$OnClickListenerC1322a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
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
        this.f21097i = null;
        this.f21098j = null;
        this.k = true;
        this.f21094f = atListActivity;
        this.f21093e = atListActivity.getPageContext().getContext();
        this.k = z;
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
            bVar.f21101b.setOnClickListener(new View$OnClickListenerC1322a(this, metaData));
            c cVar = this.f21097i;
            if (cVar != null) {
                cVar.handlerItem(bVar.a, metaData);
            }
            String avater = metaData.getAvater();
            bVar.f21103d.setText(metaData.getName_show());
            if (metaData.getIsNearlyAt() == 1) {
                bVar.f21105f.setVisibility(0);
                bVar.f21105f.setText("最近@过");
            } else if (metaData.getIsFollower() == 1) {
                bVar.f21105f.setVisibility(0);
                bVar.f21105f.setText("互相关注");
            } else if (metaData.getIsMyFollower() == 1) {
                bVar.f21105f.setVisibility(0);
                bVar.f21105f.setText("我的关注");
            } else {
                bVar.f21105f.setVisibility(8);
            }
            bVar.f21104e.setTagData(metaData);
            bVar.f21102c.setTag(avater);
            if (this.k) {
                bVar.f21104e.setVisibility(0);
            } else {
                bVar.f21104e.setVisibility(8);
            }
            bVar.f21102c.startLoad(avater, 12, false);
            UtilHelper.showHeadImageViewBigV(bVar.f21102c, metaData);
            this.f21094f.getPageContext().getLayoutMode().k(skinType == 1);
            this.f21094f.getPageContext().getLayoutMode().j(bVar.a);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b c(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.f21093e).inflate(c.a.t0.p4.h.invite_friend_list_item, (ViewGroup) null);
            bVar.a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(c.a.t0.p4.g.photo);
            bVar.f21102c = headImageView;
            headImageView.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(bVar.f21102c, metaData);
            bVar.f21101b = (LinearLayout) bVar.a.findViewById(c.a.t0.p4.g.photo_box);
            bVar.f21103d = (TextView) bVar.a.findViewById(c.a.t0.p4.g.txt_user_name);
            TextView textView = (TextView) bVar.a.findViewById(c.a.t0.p4.g.label_user);
            bVar.f21105f = textView;
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(textView);
            d2.v(c.a.t0.p4.d.CAM_X0108);
            d2.z(c.a.t0.p4.e.T_X10);
            d2.n(c.a.t0.p4.j.J_X04);
            d2.l(c.a.t0.p4.e.L_X01);
            d2.k(c.a.t0.p4.d.CAM_X0111);
            TbCheckBox tbCheckBox = (TbCheckBox) bVar.a.findViewById(c.a.t0.p4.g.ckb_select);
            bVar.f21104e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableIdIsWebP(true);
            bVar.f21104e.setBackgroundDrawableId(c.a.t0.p4.f.icon_pure_strok324_select, c.a.t0.p4.f.icon_pure_strok324);
            TbCheckBox.b bVar2 = this.f21096h;
            if (bVar2 != null) {
                bVar.f21104e.setStatedChangedListener(bVar2);
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
            ArrayList<MetaData> arrayList = this.f21095g;
            if (arrayList != null && i2 < arrayList.size()) {
                return this.f21095g.get(i2);
            }
            return null;
        }
        return (MetaData) invokeI.objValue;
    }

    public void e(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f21096h = bVar;
        }
    }

    public void f(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f21095g = arrayList;
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f21097i = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<MetaData> arrayList = this.f21095g;
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
            if (this.f21098j == null) {
                this.f21098j = viewGroup;
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
