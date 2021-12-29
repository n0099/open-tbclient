package c.a.t0.o4.u;

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
/* loaded from: classes8.dex */
public class a extends c.a.d.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f21831b;

    /* renamed from: c  reason: collision with root package name */
    public e f21832c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f21833d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f21834e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f21835f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f21836g;

    /* renamed from: c.a.t0.o4.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1313a implements TbCameraView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public C1313a(a aVar, TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.stopCamera();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "tag_image";
        this.f21831b = "tag_b_image";
        this.f21832c = eVar;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f21836g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.getBackBtn();
        }
        return (View) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImageListFragment imageListFragment = this.f21835f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.getBackBtn();
        }
        return (View) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f21836g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.getBtnNext();
        }
        return (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImageListFragment imageListFragment = this.f21835f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.getBtnNextStep();
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageListFragment imageListFragment = this.f21835f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.getCameraView();
        }
        return (TbCameraView) invokeV.objValue;
    }

    public Fragment h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 < 0 || i2 > 1) {
                return null;
            }
            return this.f21833d[i2];
        }
        return (Fragment) invokeI.objValue;
    }

    public String i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 < 0 || i2 > 1) {
                return null;
            }
            return this.f21834e[i2];
        }
        return (String) invokeI.objValue;
    }

    public ImageListFragment j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f21835f : (ImageListFragment) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageListFragment imageListFragment = this.f21835f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.getOriginSelectBtn();
        }
        return (View) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f21836g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.getOriginSelectBtn();
        }
        return (View) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f21833d = new Fragment[2];
            this.f21834e = new String[2];
            ImageListFragment imageListFragment = new ImageListFragment();
            this.f21835f = imageListFragment;
            imageListFragment.setAlbumView(this.f21832c);
            this.f21833d[0] = this.f21835f;
            this.f21834e[0] = this.a;
            AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
            this.f21836g = albumImageBrowseFragment;
            albumImageBrowseFragment.setAlbumView(this.f21832c);
            this.f21833d[1] = this.f21836g;
            this.f21834e[1] = this.f21831b;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TbCameraView g2 = g();
            if (g2 != null) {
                g2.setOnOpenCameraFailedListener(new C1313a(this, g2));
                g2.openCamera(false);
                g2.setVisibility(0);
            }
            ImageListFragment imageListFragment = this.f21835f;
            if (imageListFragment == null || imageListFragment.getGridView() == null) {
                return;
            }
            this.f21835f.getGridView().smoothScroll();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048589, this, i2) != null) {
            return;
        }
        int i3 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f21833d;
            if (i3 >= fragmentArr.length) {
                return;
            }
            if (fragmentArr[i3] != null && (fragmentArr[i3] instanceof ImageListFragment)) {
                ((ImageListFragment) fragmentArr[i3]).onChangeSkinType(i2);
            }
            i3++;
        }
    }

    public void p() {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (imageListFragment = this.f21835f) == null) {
            return;
        }
        imageListFragment.loadAlbumMediaList();
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f21836g;
            if (albumImageBrowseFragment != null) {
                albumImageBrowseFragment.selectOriginalImg(z);
            }
            ImageListFragment imageListFragment = this.f21835f;
            if (imageListFragment != null) {
                imageListFragment.selectOriginalImg(z);
            }
        }
    }

    public void r(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, navigationBar) == null) {
            this.f21835f.setNavBar(navigationBar);
        }
    }

    public void s(j jVar) {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, jVar) == null) || (imageListFragment = this.f21835f) == null) {
            return;
        }
        imageListFragment.setVideoCompressController(jVar);
    }

    public void t() {
        TbCameraView g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (g2 = g()) == null) {
            return;
        }
        g2.stopCamera();
        g2.setVisibility(4);
    }
}
