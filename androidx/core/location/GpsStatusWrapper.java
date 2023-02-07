package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class GpsStatusWrapper extends GnssStatusCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEIDOU_PRN_COUNT = 35;
    public static final int BEIDOU_PRN_OFFSET = 200;
    public static final int GLONASS_PRN_COUNT = 24;
    public static final int GLONASS_PRN_OFFSET = 64;
    public static final int GPS_PRN_COUNT = 32;
    public static final int GPS_PRN_OFFSET = 0;
    public static final int QZSS_SVID_MAX = 200;
    public static final int QZSS_SVID_MIN = 193;
    public static final int SBAS_PRN_MAX = 64;
    public static final int SBAS_PRN_MIN = 33;
    public static final int SBAS_PRN_OFFSET = -87;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("mWrapped")
    public Iterator<GpsSatellite> mCachedIterator;
    @GuardedBy("mWrapped")
    public int mCachedIteratorPosition;
    @GuardedBy("mWrapped")
    public GpsSatellite mCachedSatellite;
    @GuardedBy("mWrapped")
    public int mCachedSatelliteCount;
    public final GpsStatus mWrapped;

    public static int getConstellationFromPrn(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i <= 0 || i > 32) {
                if (i < 33 || i > 64) {
                    if (i <= 64 || i > 88) {
                        if (i <= 200 || i > 235) {
                            return (i < 193 || i > 200) ? 0 : 4;
                        }
                        return 5;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public GpsStatusWrapper(GpsStatus gpsStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gpsStatus};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.mWrapped = gpsStatus2;
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = gpsStatus2.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private GpsSatellite getSatellite(int i) {
        InterceptResult invokeI;
        GpsSatellite gpsSatellite;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            synchronized (this.mWrapped) {
                if (i < this.mCachedIteratorPosition) {
                    this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                    this.mCachedIteratorPosition = -1;
                }
                while (true) {
                    if (this.mCachedIteratorPosition >= i) {
                        break;
                    }
                    this.mCachedIteratorPosition++;
                    if (!this.mCachedIterator.hasNext()) {
                        this.mCachedSatellite = null;
                        break;
                    }
                    this.mCachedSatellite = this.mCachedIterator.next();
                }
                gpsSatellite = this.mCachedSatellite;
            }
            return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
        }
        return (GpsSatellite) invokeI.objValue;
    }

    public static int getSvidFromPrn(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            int constellationFromPrn = getConstellationFromPrn(i);
            if (constellationFromPrn != 2) {
                if (constellationFromPrn != 3) {
                    if (constellationFromPrn == 5) {
                        return i - 200;
                    }
                    return i;
                }
                return i - 64;
            }
            return i + 87;
        }
        return invokeI.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GpsStatusWrapper)) {
                return false;
            }
            return this.mWrapped.equals(((GpsStatusWrapper) obj).mWrapped);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return getSatellite(i).getAzimuth();
        }
        return invokeI.floatValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeI.floatValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeI.floatValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return getSatellite(i).getSnr();
        }
        return invokeI.floatValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (Build.VERSION.SDK_INT < 24) {
                return 1;
            }
            return getConstellationFromPrn(getSatellite(i).getPrn());
        }
        return invokeI.intValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return getSatellite(i).getElevation();
        }
        return invokeI.floatValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (Build.VERSION.SDK_INT < 24) {
                return getSatellite(i).getPrn();
            }
            return getSvidFromPrn(getSatellite(i).getPrn());
        }
        return invokeI.intValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return getSatellite(i).hasAlmanac();
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return getSatellite(i).hasEphemeris();
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            return getSatellite(i).usedInFix();
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.mWrapped) {
                if (this.mCachedSatelliteCount == -1) {
                    for (GpsSatellite gpsSatellite : this.mWrapped.getSatellites()) {
                        this.mCachedSatelliteCount++;
                    }
                    this.mCachedSatelliteCount++;
                }
                i = this.mCachedSatelliteCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mWrapped.hashCode();
        }
        return invokeV.intValue;
    }
}
