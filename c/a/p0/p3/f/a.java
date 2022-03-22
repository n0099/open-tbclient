package c.a.p0.p3.f;

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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDateFormat a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<MuteUser> f17007b;

    /* renamed from: c  reason: collision with root package name */
    public BaseActivity f17008c;

    /* renamed from: d  reason: collision with root package name */
    public e f17009d;

    /* renamed from: e  reason: collision with root package name */
    public d f17010e;

    /* renamed from: c.a.p0.p3.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1276a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MuteUser a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f17011b;

        public View$OnClickListenerC1276a(a aVar, MuteUser muteUser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, muteUser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17011b = aVar;
            this.a = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17011b.f17009d == null) {
                return;
            }
            MuteUser muteUser = this.a;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f17011b.f17009d.a(this.a.user_id.longValue(), this.a.user_name);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MuteUser a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f17012b;

        public b(a aVar, MuteUser muteUser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, muteUser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17012b = aVar;
            this.a = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17012b.f17010e == null) {
                return;
            }
            MuteUser muteUser = this.a;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f17012b.f17010e.a(this.a.user_id.longValue(), this.a.user_name);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MuteUser a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f17013b;

        public c(a aVar, MuteUser muteUser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, muteUser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17013b = aVar;
            this.a = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17013b.f17010e == null) {
                return;
            }
            MuteUser muteUser = this.a;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f17013b.f17010e.a(this.a.user_id.longValue(), this.a.user_name);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(long j, String str);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(long j, String str);
    }

    /* loaded from: classes2.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f17014b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17015c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17016d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17017e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1276a view$OnClickListenerC1276a) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17008c = baseActivity;
        this.f17009d = eVar;
        this.f17010e = dVar;
        this.a = new SimpleDateFormat("yyyy.MM.dd");
    }

    public final f c(Object obj, MuteUser muteUser, int i) {
        InterceptResult invokeLLI;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, obj, muteUser, i)) == null) {
            if (obj == null) {
                fVar = new f(this, null);
                View inflate = LayoutInflater.from(this.f17008c.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0866, (ViewGroup) null);
                fVar.a = inflate;
                fVar.f17015c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090fb1);
                fVar.f17016d = (TextView) fVar.a.findViewById(R.id.obfuscated_res_0x7f090f86);
                fVar.f17017e = (TextView) fVar.a.findViewById(R.id.obfuscated_res_0x7f090f99);
                fVar.f17014b = (HeadImageView) fVar.a.findViewById(R.id.obfuscated_res_0x7f090f78);
                fVar.a.setTag(fVar);
                fVar.f17017e.setTag(Integer.valueOf(i));
                fVar.f17014b.setTag(Integer.valueOf(i));
                fVar.f17015c.setTag(Integer.valueOf(i));
            } else {
                fVar = (f) obj;
            }
            fVar.f17017e.setOnClickListener(new View$OnClickListenerC1276a(this, muteUser));
            fVar.f17014b.setOnClickListener(new b(this, muteUser));
            fVar.f17015c.setOnClickListener(new c(this, muteUser));
            String str = muteUser.portrait;
            if (str != null) {
                fVar.f17014b.setTag(str);
                fVar.f17014b.J(str, 12, false);
            }
            String str2 = muteUser.name_show;
            if (str2 != null) {
                fVar.f17015c.setText(str2);
            } else {
                fVar.f17015c.setText(muteUser.user_name);
            }
            if (muteUser.mute_time != null) {
                fVar.f17016d.setText(this.f17008c.getResources().getString(R.string.obfuscated_res_0x7f0f02b3, this.a.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
            }
            Long l = muteUser.user_id;
            if (l != null) {
                fVar.f17017e.setTag(l);
            }
            this.f17008c.getLayoutMode().j(fVar.a);
            return fVar;
        }
        return (f) invokeLLI.objValue;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f17007b = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<MuteUser> arrayList = this.f17007b;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ArrayList<MuteUser> arrayList = this.f17007b;
            if (arrayList != null) {
                return arrayList.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view, viewGroup)) == null) {
            MuteUser muteUser = this.f17007b.get(i);
            if (muteUser != null) {
                fVar = c(view != null ? view.getTag() : null, muteUser, i);
            } else {
                fVar = null;
            }
            if (fVar != null) {
                return fVar.a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
