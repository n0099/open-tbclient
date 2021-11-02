package b.a.r0.c3.f;

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
    public SimpleDateFormat f15320e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f15321f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f15322g;

    /* renamed from: h  reason: collision with root package name */
    public e f15323h;

    /* renamed from: i  reason: collision with root package name */
    public d f15324i;

    /* renamed from: b.a.r0.c3.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0771a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f15325e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15326f;

        public View$OnClickListenerC0771a(a aVar, MuteUser muteUser) {
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
            this.f15326f = aVar;
            this.f15325e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15326f.f15323h == null) {
                return;
            }
            MuteUser muteUser = this.f15325e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f15326f.f15323h.a(this.f15325e.user_id.longValue(), this.f15325e.user_name);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f15327e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15328f;

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
            this.f15328f = aVar;
            this.f15327e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15328f.f15324i == null) {
                return;
            }
            MuteUser muteUser = this.f15327e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f15328f.f15324i.a(this.f15327e.user_id.longValue(), this.f15327e.user_name);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f15329e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15330f;

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
            this.f15330f = aVar;
            this.f15329e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15330f.f15324i == null) {
                return;
            }
            MuteUser muteUser = this.f15329e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f15330f.f15324i.a(this.f15329e.user_id.longValue(), this.f15329e.user_name);
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
        public View f15331a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f15332b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15333c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15334d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15335e;

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

        public /* synthetic */ f(a aVar, View$OnClickListenerC0771a view$OnClickListenerC0771a) {
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
        this.f15322g = baseActivity;
        this.f15323h = eVar;
        this.f15324i = dVar;
        this.f15320e = new SimpleDateFormat("yyyy.MM.dd");
    }

    public final f c(Object obj, MuteUser muteUser, int i2) {
        InterceptResult invokeLLI;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, obj, muteUser, i2)) == null) {
            if (obj == null) {
                fVar = new f(this, null);
                View inflate = LayoutInflater.from(this.f15322g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
                fVar.f15331a = inflate;
                fVar.f15333c = (TextView) inflate.findViewById(R.id.item_user_name);
                fVar.f15334d = (TextView) fVar.f15331a.findViewById(R.id.item_mute_terminate_time);
                fVar.f15335e = (TextView) fVar.f15331a.findViewById(R.id.item_remove_button);
                fVar.f15332b = (HeadImageView) fVar.f15331a.findViewById(R.id.item_header_view);
                fVar.f15331a.setTag(fVar);
                fVar.f15335e.setTag(Integer.valueOf(i2));
                fVar.f15332b.setTag(Integer.valueOf(i2));
                fVar.f15333c.setTag(Integer.valueOf(i2));
            } else {
                fVar = (f) obj;
            }
            fVar.f15335e.setOnClickListener(new View$OnClickListenerC0771a(this, muteUser));
            fVar.f15332b.setOnClickListener(new b(this, muteUser));
            fVar.f15333c.setOnClickListener(new c(this, muteUser));
            String str = muteUser.portrait;
            if (str != null) {
                fVar.f15332b.setTag(str);
                fVar.f15332b.startLoad(str, 12, false);
            }
            String str2 = muteUser.name_show;
            if (str2 != null) {
                fVar.f15333c.setText(str2);
            } else {
                fVar.f15333c.setText(muteUser.user_name);
            }
            if (muteUser.mute_time != null) {
                fVar.f15334d.setText(this.f15322g.getResources().getString(R.string.auto_terminate_mute_time, this.f15320e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
            }
            Long l = muteUser.user_id;
            if (l != null) {
                fVar.f15335e.setTag(l);
            }
            this.f15322g.getLayoutMode().j(fVar.f15331a);
            return fVar;
        }
        return (f) invokeLLI.objValue;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f15321f = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<MuteUser> arrayList = this.f15321f;
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
            ArrayList<MuteUser> arrayList = this.f15321f;
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
            MuteUser muteUser = this.f15321f.get(i2);
            if (muteUser != null) {
                fVar = c(view != null ? view.getTag() : null, muteUser, i2);
            } else {
                fVar = null;
            }
            if (fVar != null) {
                return fVar.f15331a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
