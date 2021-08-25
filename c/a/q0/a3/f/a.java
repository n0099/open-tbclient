package c.a.q0.a3.f;

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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f15595e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f15596f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f15597g;

    /* renamed from: h  reason: collision with root package name */
    public e f15598h;

    /* renamed from: i  reason: collision with root package name */
    public d f15599i;

    /* renamed from: c.a.q0.a3.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0734a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f15600e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15601f;

        public View$OnClickListenerC0734a(a aVar, MuteUser muteUser) {
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
            this.f15601f = aVar;
            this.f15600e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15601f.f15598h == null) {
                return;
            }
            MuteUser muteUser = this.f15600e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f15601f.f15598h.a(this.f15600e.user_id.longValue(), this.f15600e.user_name);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f15602e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15603f;

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
            this.f15603f = aVar;
            this.f15602e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15603f.f15599i == null) {
                return;
            }
            MuteUser muteUser = this.f15602e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f15603f.f15599i.a(this.f15602e.user_id.longValue(), this.f15602e.user_name);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f15604e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15605f;

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
            this.f15605f = aVar;
            this.f15604e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15605f.f15599i == null) {
                return;
            }
            MuteUser muteUser = this.f15604e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f15605f.f15599i.a(this.f15604e.user_id.longValue(), this.f15604e.user_name);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(long j2, String str);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(long j2, String str);
    }

    /* loaded from: classes3.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f15606a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f15607b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15608c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15609d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15610e;

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

        public /* synthetic */ f(a aVar, View$OnClickListenerC0734a view$OnClickListenerC0734a) {
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
        this.f15597g = baseActivity;
        this.f15598h = eVar;
        this.f15599i = dVar;
        this.f15595e = new SimpleDateFormat("yyyy.MM.dd");
    }

    public final f c(Object obj, MuteUser muteUser, int i2) {
        InterceptResult invokeLLI;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, obj, muteUser, i2)) == null) {
            if (obj == null) {
                fVar = new f(this, null);
                View inflate = LayoutInflater.from(this.f15597g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
                fVar.f15606a = inflate;
                fVar.f15608c = (TextView) inflate.findViewById(R.id.item_user_name);
                fVar.f15609d = (TextView) fVar.f15606a.findViewById(R.id.item_mute_terminate_time);
                fVar.f15610e = (TextView) fVar.f15606a.findViewById(R.id.item_remove_button);
                fVar.f15607b = (HeadImageView) fVar.f15606a.findViewById(R.id.item_header_view);
                fVar.f15606a.setTag(fVar);
                fVar.f15610e.setTag(Integer.valueOf(i2));
                fVar.f15607b.setTag(Integer.valueOf(i2));
                fVar.f15608c.setTag(Integer.valueOf(i2));
            } else {
                fVar = (f) obj;
            }
            fVar.f15610e.setOnClickListener(new View$OnClickListenerC0734a(this, muteUser));
            fVar.f15607b.setOnClickListener(new b(this, muteUser));
            fVar.f15608c.setOnClickListener(new c(this, muteUser));
            String str = muteUser.portrait;
            if (str != null) {
                fVar.f15607b.setTag(str);
                fVar.f15607b.startLoad(str, 12, false);
            }
            String str2 = muteUser.name_show;
            if (str2 != null) {
                fVar.f15608c.setText(str2);
            } else {
                fVar.f15608c.setText(muteUser.user_name);
            }
            if (muteUser.mute_time != null) {
                fVar.f15609d.setText(this.f15597g.getResources().getString(R.string.auto_terminate_mute_time, this.f15595e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
            }
            Long l = muteUser.user_id;
            if (l != null) {
                fVar.f15610e.setTag(l);
            }
            this.f15597g.getLayoutMode().j(fVar.f15606a);
            return fVar;
        }
        return (f) invokeLLI.objValue;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f15596f = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<MuteUser> arrayList = this.f15596f;
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
            ArrayList<MuteUser> arrayList = this.f15596f;
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
            MuteUser muteUser = this.f15596f.get(i2);
            if (muteUser != null) {
                fVar = c(view != null ? view.getTag() : null, muteUser, i2);
            } else {
                fVar = null;
            }
            if (fVar != null) {
                return fVar.f15606a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
