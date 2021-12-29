package c.a.t0.s1.f.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.s0.t.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes8.dex */
public abstract class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f22580e;

    /* renamed from: f  reason: collision with root package name */
    public List<ImMessageCenterShowItemData> f22581f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22582g;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f22583b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f22584c;

        /* renamed from: d  reason: collision with root package name */
        public BarImageView f22585d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22586e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f22587f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f22588g;

        /* renamed from: h  reason: collision with root package name */
        public MessageRedDotView f22589h;

        /* renamed from: i  reason: collision with root package name */
        public View f22590i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f22591j;

        /* renamed from: k  reason: collision with root package name */
        public ImageView f22592k;
        public ImageView l;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f22583b = null;
            this.f22586e = null;
            this.f22587f = null;
            this.f22588g = null;
            this.f22589h = null;
            this.f22590i = null;
            this.f22591j = null;
            this.f22592k = null;
            this.l = null;
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22580e = null;
        this.f22581f = null;
        this.f22582g = false;
        this.f22580e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImMessageCenterShowItemData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<ImMessageCenterShowItemData> list = this.f22581f;
            if (list == null || list.size() == 0 || i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f22581f.get(i2);
        }
        return (ImMessageCenterShowItemData) invokeI.objValue;
    }

    public a b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            a aVar = new a(this);
            aVar.a = (ViewGroup) view.findViewById(R.id.chat_item);
            aVar.f22584c = (ImageView) view.findViewById(R.id.svg_head);
            aVar.f22583b = (HeadImageView) view.findViewById(R.id.chat_head);
            aVar.f22585d = (BarImageView) view.findViewById(R.id.forum_head);
            aVar.f22586e = (TextView) view.findViewById(R.id.chat_name);
            aVar.f22587f = (TextView) view.findViewById(R.id.last_chat_content);
            aVar.f22588g = (TextView) view.findViewById(R.id.chat_time);
            aVar.f22590i = view.findViewById(R.id.line);
            MessageRedDotView messageRedDotView = (MessageRedDotView) view.findViewById(R.id.new_message);
            aVar.f22589h = messageRedDotView;
            messageRedDotView.setShadowEnabled(false);
            aVar.f22591j = (ImageView) view.findViewById(R.id.iv_bell);
            aVar.f22592k = (ImageView) view.findViewById(R.id.send_status);
            aVar.l = (ImageView) view.findViewById(R.id.select_status);
            aVar.f22583b.setPlaceHolder(1);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22582g : invokeV.booleanValue;
    }

    public abstract boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, aVar, imMessageCenterShowItemData) == null) || aVar == null) {
            return;
        }
        if (imMessageCenterShowItemData == null) {
            aVar.f22591j.setVisibility(8);
        } else if (d(imMessageCenterShowItemData)) {
            ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
            if (groupSetting == null) {
                aVar.f22591j.setVisibility(8);
            } else if (!groupSetting.isAcceptNotify()) {
                aVar.f22591j.setVisibility(0);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(aVar.f22591j, R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                aVar.f22591j.setVisibility(8);
            }
        } else {
            aVar.f22591j.setVisibility(8);
        }
    }

    public abstract void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<ImMessageCenterShowItemData> list = this.f22581f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            a aVar = (view == null || !(view.getTag() instanceof a)) ? null : (a) view.getTag();
            if (aVar == null) {
                view = LayoutInflater.from(this.f22580e).inflate(R.layout.chat_list_item, viewGroup, false);
                aVar = b(view);
                view.setTag(aVar);
            }
            SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
            SkinManager.setBackgroundResource(aVar.f22590i, R.color.CAM_X0205);
            aVar.a.setVisibility(0);
            ImMessageCenterShowItemData item = getItem(i2);
            if (item != null) {
                i(aVar, item);
                h(aVar, item);
                k(aVar, item);
                l(aVar, item);
                g(aVar, item);
                m(aVar, item);
                f(aVar, item);
                j(aVar, item);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, imMessageCenterShowItemData) == null) {
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                aVar.f22587f.setText("");
            } else {
                aVar.f22587f.setText(imMessageCenterShowItemData.getMsgContent());
            }
        }
    }

    public void i(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, aVar, imMessageCenterShowItemData) == null) || imMessageCenterShowItemData == null) {
            return;
        }
        aVar.f22586e.setText(imMessageCenterShowItemData.getFriendNameShow());
    }

    public void j(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, aVar, imMessageCenterShowItemData) == null) {
            if (this.f22582g) {
                aVar.l.setVisibility(0);
                if (imMessageCenterShowItemData.isSelected()) {
                    SkinManager.setBackgroundResource(aVar.l, R.drawable.btn_bgb_choice_s);
                    SkinManager.setBackgroundColor(aVar.a, R.color.CAM_X0205);
                    return;
                }
                SkinManager.setBackgroundResource(aVar.l, R.drawable.btn_bgb_choice_n);
                SkinManager.setBackgroundColor(aVar.a, R.color.CAM_X0205);
                return;
            }
            aVar.l.setVisibility(8);
            TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void k(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, aVar, imMessageCenterShowItemData) == null) || aVar == null || imMessageCenterShowItemData == null || imMessageCenterShowItemData.getOwnerName() == null) {
            return;
        }
        if (e(imMessageCenterShowItemData)) {
            aVar.f22592k.setVisibility(0);
            if (imMessageCenterShowItemData.getSendStatus() == 2) {
                SkinManager.setBackgroundResource(aVar.f22592k, R.drawable.icon_send_failed_information);
                return;
            } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                SkinManager.setBackgroundResource(aVar.f22592k, R.drawable.icon_send_in_information);
                return;
            } else {
                aVar.f22592k.setVisibility(8);
                return;
            }
        }
        aVar.f22592k.setVisibility(8);
    }

    public void l(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, aVar, imMessageCenterShowItemData) == null) || aVar == null || imMessageCenterShowItemData == null) {
            return;
        }
        Date date = new Date();
        date.setTime(imMessageCenterShowItemData.getServerTime());
        aVar.f22588g.setText(imMessageCenterShowItemData.getServerTime() != 0 ? StringHelper.getChatTimeString(date) : "");
    }

    public void m(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) == null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            if (unReadCount > 0) {
                if (d.d().e() == 0) {
                    unReadCount = 0;
                } else {
                    BasicNameValuePair p = p(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                    if (p != null && p.getName() != null && p.getName().length() > 0) {
                        unReadCount = c.a.d.f.m.b.e(p.getName(), 0);
                    }
                }
                aVar.f22589h.setThreeDotMode(2);
                aVar.f22589h.refresh(unReadCount);
                aVar.f22589h.setVisibility(0);
            } else {
                aVar.f22589h.setVisibility(8);
            }
            SkinManager.setViewTextColor(aVar.f22586e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(aVar.f22587f, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(aVar.f22588g, R.color.CAM_X0109, 1);
        }
    }

    public void n(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            if (this.f22581f == null) {
                this.f22581f = new LinkedList();
            }
            this.f22581f = list;
            notifyDataSetChanged();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f22582g = z;
        }
    }

    public abstract BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str);
}
