package b.a.r0.d3.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f16952e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f16953f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f16954g;

    /* renamed from: h  reason: collision with root package name */
    public e f16955h;

    /* renamed from: i  reason: collision with root package name */
    public d f16956i;

    /* renamed from: b.a.r0.d3.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0848a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f16957e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16958f;

        public View$OnClickListenerC0848a(a aVar, MuteUser muteUser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, muteUser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16958f = aVar;
            this.f16957e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16958f.f16955h == null) {
                return;
            }
            MuteUser muteUser = this.f16957e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f16958f.f16955h.a(this.f16957e.user_id.longValue(), this.f16957e.user_name);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f16959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16960f;

        public b(a aVar, MuteUser muteUser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, muteUser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16960f = aVar;
            this.f16959e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16960f.f16956i == null) {
                return;
            }
            MuteUser muteUser = this.f16959e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f16960f.f16956i.a(this.f16959e.user_id.longValue(), this.f16959e.user_name);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f16961e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16962f;

        public c(a aVar, MuteUser muteUser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, muteUser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16962f = aVar;
            this.f16961e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16962f.f16956i == null) {
                return;
            }
            MuteUser muteUser = this.f16961e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f16962f.f16956i.a(this.f16961e.user_id.longValue(), this.f16961e.user_name);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(long j, String str);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(long j, String str);
    }

    /* loaded from: classes4.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f16963a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f16964b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16965c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16966d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f16967e;

        public f(a aVar) {
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

        public /* synthetic */ f(a aVar, View$OnClickListenerC0848a view$OnClickListenerC0848a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, eVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16954g = baseActivity;
        this.f16955h = eVar;
        this.f16956i = dVar;
        this.f16952e = new SimpleDateFormat("yyyy.MM.dd");
    }

    public final f c(Object obj, MuteUser muteUser, int i2) {
        InterceptResult invokeLLI;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, obj, muteUser, i2)) == null) {
            if (obj == null) {
                fVar = new f(this, null);
                View inflate = LayoutInflater.from(this.f16954g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
                fVar.f16963a = inflate;
                fVar.f16965c = (TextView) inflate.findViewById(R.id.item_user_name);
                fVar.f16966d = (TextView) fVar.f16963a.findViewById(R.id.item_mute_terminate_time);
                fVar.f16967e = (TextView) fVar.f16963a.findViewById(R.id.item_remove_button);
                fVar.f16964b = (HeadImageView) fVar.f16963a.findViewById(R.id.item_header_view);
                fVar.f16963a.setTag(fVar);
                fVar.f16967e.setTag(Integer.valueOf(i2));
                fVar.f16964b.setTag(Integer.valueOf(i2));
                fVar.f16965c.setTag(Integer.valueOf(i2));
            } else {
                fVar = (f) obj;
            }
            fVar.f16967e.setOnClickListener(new View$OnClickListenerC0848a(this, muteUser));
            fVar.f16964b.setOnClickListener(new b(this, muteUser));
            fVar.f16965c.setOnClickListener(new c(this, muteUser));
            String str = muteUser.portrait;
            if (str != null) {
                fVar.f16964b.setTag(str);
                fVar.f16964b.startLoad(str, 12, false);
            }
            String str2 = muteUser.name_show;
            if (str2 != null) {
                fVar.f16965c.setText(str2);
            } else {
                fVar.f16965c.setText(muteUser.user_name);
            }
            if (muteUser.mute_time != null) {
                fVar.f16966d.setText(this.f16954g.getResources().getString(R.string.auto_terminate_mute_time, this.f16952e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
            }
            Long l = muteUser.user_id;
            if (l != null) {
                fVar.f16967e.setTag(l);
            }
            this.f16954g.getLayoutMode().j(fVar.f16963a);
            return fVar;
        }
        return (f) invokeLLI.objValue;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f16953f = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<MuteUser> arrayList = this.f16953f;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ArrayList<MuteUser> arrayList = this.f16953f;
            if (arrayList != null) {
                return arrayList.get(i2);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            MuteUser muteUser = this.f16953f.get(i2);
            if (muteUser != null) {
                fVar = c(view != null ? view.getTag() : null, muteUser, i2);
            } else {
                fVar = null;
            }
            if (fVar != null) {
                return fVar.f16963a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
