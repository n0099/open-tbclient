package b.a.r0.f0;

import android.location.Location;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.d1.o;
import b.a.r0.f0.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class h implements c.a {
    public static /* synthetic */ Interceptable $ic;
    public static h j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f16353a;

    /* renamed from: b  reason: collision with root package name */
    public c f16354b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TransmitForumData> f16355c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TransmitForumData> f16356d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16357e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f16358f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16359g;

    /* renamed from: h  reason: collision with root package name */
    public int f16360h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16361i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1654723886, "Lb/a/r0/f0/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1654723886, "Lb/a/r0/f0/h;");
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16355c = new ArrayList<>();
        this.f16357e = false;
        this.f16359g = false;
        this.f16361i = false;
        e();
    }

    public static Location b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return null;
        }
        return (Location) invokeV.objValue;
    }

    public static h c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (j == null) {
                synchronized (h.class) {
                    if (j == null) {
                        j = new h();
                    }
                }
            }
            return j;
        }
        return (h) invokeV.objValue;
    }

    @Override // b.a.r0.f0.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (i2 == 1) {
                if (z) {
                    this.f16358f = arrayList;
                }
                this.f16359g = true;
            } else if (i2 == 2) {
                if (z) {
                    this.f16356d = arrayList;
                    this.f16360h = i3;
                }
                this.f16357e = true;
            }
            j();
        }
    }

    public final Location d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() : (Location) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
            f();
            this.f16361i = false;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), c.class);
            if (runTask != null) {
                this.f16354b = (c) runTask.getData();
            }
            c cVar = this.f16354b;
            if (cVar != null) {
                cVar.a(this);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), c.class);
            if (runTask != null) {
                this.f16353a = (c) runTask.getData();
            }
            c cVar = this.f16353a;
            if (cVar != null) {
                cVar.a(this);
            }
        }
    }

    public final boolean h(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            ArrayList<TransmitForumData> arrayList = this.f16355c;
            if (arrayList == null) {
                return false;
            }
            Iterator<TransmitForumData> it = arrayList.iterator();
            while (it.hasNext()) {
                TransmitForumData next = it.next();
                if (next != null && next.forumId == j2) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16361i = true;
            c cVar = this.f16353a;
            if (cVar != null) {
                cVar.b();
            }
            c cVar2 = this.f16354b;
            if (cVar2 != null) {
                cVar2.b();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f16353a == null || this.f16357e) {
                if (this.f16354b == null || this.f16359g) {
                    this.f16357e = false;
                    this.f16359g = false;
                    this.f16361i = false;
                    this.f16355c.clear();
                    if (!ListUtils.isEmpty(this.f16356d)) {
                        Iterator<TransmitForumData> it = this.f16356d.iterator();
                        while (it.hasNext()) {
                            TransmitForumData next = it.next();
                            if (!h(next.forumId)) {
                                this.f16355c.add(next);
                            }
                        }
                    }
                    if (!ListUtils.isEmpty(this.f16358f)) {
                        Iterator<TransmitForumData> it2 = this.f16358f.iterator();
                        while (it2.hasNext()) {
                            TransmitForumData next2 = it2.next();
                            if (!h(next2.forumId)) {
                                this.f16355c.add(next2);
                            }
                        }
                    }
                    this.f16356d = null;
                    this.f16358f = null;
                    k();
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.f16355c));
        }
    }

    public void l(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, shareDialogConfig) == null) || shareDialogConfig == null || shareDialogConfig.shareItem == null || o.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.B = d();
        }
        if (l.D() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.f16361i && !shareDialogConfig.shareItem.f()) {
            i();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.f16355c);
        shareDialogConfig.setPrivateThread(this.f16360h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
