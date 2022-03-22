package c.a.p0.s4.k;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends c.a.d.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18328b;

    /* renamed from: c  reason: collision with root package name */
    public e f18329c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f18330d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f18331e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f18332f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f18333g;

    /* renamed from: c.a.p0.s4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1387a implements TbCameraView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public C1387a(a aVar, TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "tag_image";
        this.f18328b = "tag_b_image";
        this.f18329c = eVar;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f18333g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.O0();
        }
        return (View) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImageListFragment imageListFragment = this.f18332f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.V0();
        }
        return (View) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f18333g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.P0();
        }
        return (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImageListFragment imageListFragment = this.f18332f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.W0();
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageListFragment imageListFragment = this.f18332f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.X0();
        }
        return (TbCameraView) invokeV.objValue;
    }

    public Fragment j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i < 0 || i > 1) {
                return null;
            }
            return this.f18330d[i];
        }
        return (Fragment) invokeI.objValue;
    }

    public String k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i < 0 || i > 1) {
                return null;
            }
            return this.f18331e[i];
        }
        return (String) invokeI.objValue;
    }

    public ImageListFragment l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f18332f : (ImageListFragment) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageListFragment imageListFragment = this.f18332f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.Z0();
        }
        return (View) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f18333g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.Q0();
        }
        return (View) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f18330d = new Fragment[2];
            this.f18331e = new String[2];
            ImageListFragment imageListFragment = new ImageListFragment();
            this.f18332f = imageListFragment;
            imageListFragment.f1(this.f18329c);
            this.f18330d[0] = this.f18332f;
            this.f18331e[0] = this.a;
            AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
            this.f18333g = albumImageBrowseFragment;
            albumImageBrowseFragment.V0(this.f18329c);
            this.f18330d[1] = this.f18333g;
            this.f18331e[1] = this.f18328b;
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048587, this, i) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f18330d;
            if (i2 >= fragmentArr.length) {
                return;
            }
            if (fragmentArr[i2] != null && (fragmentArr[i2] instanceof ImageListFragment)) {
                ((ImageListFragment) fragmentArr[i2]).onChangeSkinType(i);
            }
            i2++;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbCameraView i = i();
            if (i != null) {
                i.setOnOpenCameraFailedListener(new C1387a(this, i));
                i.m(false);
                i.setVisibility(0);
            }
            ImageListFragment imageListFragment = this.f18332f;
            if (imageListFragment == null || imageListFragment.Y0() == null) {
                return;
            }
            this.f18332f.Y0().n();
        }
    }

    public void r() {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (imageListFragment = this.f18332f) == null) {
            return;
        }
        imageListFragment.a1();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f18333g;
            if (albumImageBrowseFragment != null) {
                albumImageBrowseFragment.U0(z);
            }
            ImageListFragment imageListFragment = this.f18332f;
            if (imageListFragment != null) {
                imageListFragment.e1(z);
            }
        }
    }

    public void t(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, navigationBar) == null) {
            this.f18332f.g1(navigationBar);
        }
    }

    public void u(j jVar) {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, jVar) == null) || (imageListFragment = this.f18332f) == null) {
            return;
        }
        imageListFragment.h1(jVar);
    }

    public void v() {
        TbCameraView i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (i = i()) == null) {
            return;
        }
        i.o();
        i.setVisibility(4);
    }
}
