package com.baidu.platform.core.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhKeyValue;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherLifeIndexes;
import com.baidu.mapapi.search.weather.WeatherResult;
import com.baidu.mapapi.search.weather.WeatherSearchAlerts;
import com.baidu.mapapi.search.weather.WeatherSearchForecastForHours;
import com.baidu.mapapi.search.weather.WeatherSearchForecasts;
import com.baidu.mapapi.search.weather.WeatherSearchLocation;
import com.baidu.mapapi.search.weather.WeatherSearchRealTime;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(WeatherSearchLocation weatherSearchLocation, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, weatherSearchLocation, jSONObject) == null) {
            weatherSearchLocation.setCountry(jSONObject.optString("country"));
            weatherSearchLocation.setProvince(jSONObject.optString("province"));
            weatherSearchLocation.setCity(jSONObject.optString("city"));
            weatherSearchLocation.setDistrictName(jSONObject.optString("name"));
            weatherSearchLocation.setDistrictID(jSONObject.optString("id"));
        }
    }

    private boolean b(JSONObject jSONObject, WeatherResult weatherResult) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject, weatherResult)) == null) {
            if (jSONObject == null || weatherResult == null || (optJSONObject = jSONObject.optJSONObject("location")) == null) {
                return false;
            }
            if (weatherResult.getLocation() == null) {
                WeatherSearchLocation weatherSearchLocation = new WeatherSearchLocation();
                a(weatherSearchLocation, optJSONObject);
                weatherResult.setLocation(weatherSearchLocation);
                return true;
            }
            a(weatherResult.getLocation(), optJSONObject);
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean c(JSONObject jSONObject, WeatherResult weatherResult) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, jSONObject, weatherResult)) == null) {
            if (jSONObject == null || weatherResult == null || (optJSONObject = jSONObject.optJSONObject("now")) == null) {
                return false;
            }
            if (weatherResult.getRealTimeWeather() == null) {
                WeatherSearchRealTime weatherSearchRealTime = new WeatherSearchRealTime();
                a(weatherSearchRealTime, optJSONObject);
                weatherResult.setRealTimeWeather(weatherSearchRealTime);
                return true;
            }
            a(weatherResult.getRealTimeWeather(), optJSONObject);
            return true;
        }
        return invokeLL.booleanValue;
    }

    private void a(WeatherSearchRealTime weatherSearchRealTime, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, weatherSearchRealTime, jSONObject) == null) {
            weatherSearchRealTime.setPhenomenon(jSONObject.optString("text"));
            weatherSearchRealTime.setTemperature(jSONObject.optInt(SevenZipUtils.FILE_NAME_TEMP));
            weatherSearchRealTime.setSensoryTemp(jSONObject.optInt("feels_like"));
            weatherSearchRealTime.setRelativeHumidity(jSONObject.optInt("rh"));
            weatherSearchRealTime.setWindPower(jSONObject.optString("wind_class"));
            weatherSearchRealTime.setWindDirection(jSONObject.optString("wind_dir"));
            weatherSearchRealTime.setUpdateTime(jSONObject.optString(Config.DEVICE_UPTIME));
            weatherSearchRealTime.setCO((float) jSONObject.optDouble("co"));
            weatherSearchRealTime.setNO2(jSONObject.optInt("no2"));
            weatherSearchRealTime.setPM10(jSONObject.optInt("pm10"));
            weatherSearchRealTime.setPM2_5(jSONObject.optInt("pm25"));
            weatherSearchRealTime.setClouds(jSONObject.optInt("clouds"));
            weatherSearchRealTime.setAirQualityIndex(jSONObject.optInt("aqi"));
            weatherSearchRealTime.setSO2(jSONObject.optInt("so2"));
            weatherSearchRealTime.setVisibility(jSONObject.optInt("vis"));
            weatherSearchRealTime.setO3(jSONObject.optInt("o3"));
            weatherSearchRealTime.setHourlyPrecipitation(jSONObject.optInt("prec_1h"));
        }
    }

    private boolean g(JSONObject jSONObject, WeatherResult weatherResult) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, jSONObject, weatherResult)) == null) {
            if (jSONObject == null || weatherResult == null || (optJSONArray = jSONObject.optJSONArray("forecast_hours")) == null) {
                return false;
            }
            if (weatherResult.getForecastHours() == null) {
                weatherResult.setForecastHours(new ArrayList());
            }
            JSONObject jSONObject2 = null;
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    jSONObject2 = (JSONObject) optJSONArray.get(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jSONObject2 != null) {
                    WeatherSearchForecastForHours weatherSearchForecastForHours = new WeatherSearchForecastForHours();
                    weatherSearchForecastForHours.setClouds(jSONObject2.optInt("clouds"));
                    weatherSearchForecastForHours.setDataTime(jSONObject2.optString("data_time"));
                    weatherSearchForecastForHours.setHourlyPrecipitation(jSONObject2.optInt("prec_1h"));
                    weatherSearchForecastForHours.setRelativeHumidity(jSONObject2.optInt("rh"));
                    weatherSearchForecastForHours.setTemperature(jSONObject2.optInt("temp_fc"));
                    weatherSearchForecastForHours.setPhenomenon(jSONObject2.optString("text"));
                    weatherSearchForecastForHours.setWindDirection(jSONObject2.optString("wind_dir"));
                    weatherSearchForecastForHours.setWindPower(jSONObject2.optString("wind_class"));
                    weatherResult.getForecastHours().add(weatherSearchForecastForHours);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONObject jSONObject, WeatherResult weatherResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, jSONObject, weatherResult)) == null) {
            weatherResult.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                return false;
            }
            b(optJSONObject, weatherResult);
            c(optJSONObject, weatherResult);
            e(optJSONObject, weatherResult);
            g(optJSONObject, weatherResult);
            d(optJSONObject, weatherResult);
            f(optJSONObject, weatherResult);
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(JSONObject jSONObject, WeatherResult weatherResult) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        JSONObject jSONObject2;
        JSONException e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, jSONObject, weatherResult)) == null) {
            if (jSONObject == null || weatherResult == null || (optJSONArray = jSONObject.optJSONArray("forecasts")) == null) {
                return false;
            }
            if (weatherResult.getForecasts() == null) {
                weatherResult.setForecasts(new ArrayList());
            }
            JSONObject jSONObject3 = null;
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    jSONObject2 = (JSONObject) optJSONArray.get(i);
                    try {
                        new WeatherSearchForecasts();
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        jSONObject3 = jSONObject2;
                        if (jSONObject3 == null) {
                        }
                    }
                } catch (JSONException e3) {
                    jSONObject2 = jSONObject3;
                    e = e3;
                }
                jSONObject3 = jSONObject2;
                if (jSONObject3 == null) {
                    WeatherSearchForecasts weatherSearchForecasts = new WeatherSearchForecasts();
                    weatherSearchForecasts.setDate(jSONObject3.optString(GfhKeyValue.TYPE_DATE));
                    weatherSearchForecasts.setHighestTemp(jSONObject3.optInt("high"));
                    weatherSearchForecasts.setLowestTemp(jSONObject3.optInt(Config.EXCEPTION_MEMORY_LOW));
                    weatherSearchForecasts.setPhenomenonDay(jSONObject3.optString("text_day"));
                    weatherSearchForecasts.setPhenomenonNight(jSONObject3.optString("text_night"));
                    weatherSearchForecasts.setWeek(jSONObject3.optString("week"));
                    weatherSearchForecasts.setWindDirectionDay(jSONObject3.optString("wd_day"));
                    weatherSearchForecasts.setWindPowerDay(jSONObject3.optString("wc_day"));
                    weatherSearchForecasts.setWindDirectionNight(jSONObject3.optString("wd_night"));
                    weatherSearchForecasts.setWindPowerNight(jSONObject3.optString("wc_night"));
                    weatherSearchForecasts.setAirQualityIndex(jSONObject3.optInt("aqi"));
                    weatherResult.getForecasts().add(weatherSearchForecasts);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean e(JSONObject jSONObject, WeatherResult weatherResult) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, jSONObject, weatherResult)) == null) {
            if (jSONObject == null || weatherResult == null || (optJSONArray = jSONObject.optJSONArray("alerts")) == null) {
                return false;
            }
            if (weatherResult.getWeatherAlerts() == null) {
                weatherResult.setWeatherAlerts(new ArrayList());
            }
            JSONObject jSONObject2 = null;
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    jSONObject2 = (JSONObject) optJSONArray.get(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jSONObject2 != null) {
                    WeatherSearchAlerts weatherSearchAlerts = new WeatherSearchAlerts();
                    weatherSearchAlerts.setDesc(jSONObject2.optString("desc"));
                    weatherSearchAlerts.setLevel(jSONObject2.optString("level"));
                    weatherSearchAlerts.setTitle(jSONObject2.optString("title"));
                    weatherSearchAlerts.setType(jSONObject2.optString("type"));
                    weatherResult.getWeatherAlerts().add(weatherSearchAlerts);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean f(JSONObject jSONObject, WeatherResult weatherResult) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, jSONObject, weatherResult)) == null) {
            if (jSONObject == null || weatherResult == null || (optJSONArray = jSONObject.optJSONArray("indexes")) == null) {
                return false;
            }
            if (weatherResult.getLifeIndexes() == null) {
                weatherResult.setLifeIndexes(new ArrayList());
            }
            JSONObject jSONObject2 = null;
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    jSONObject2 = (JSONObject) optJSONArray.get(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jSONObject2 != null) {
                    WeatherLifeIndexes weatherLifeIndexes = new WeatherLifeIndexes();
                    weatherLifeIndexes.setBrief(jSONObject2.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF));
                    weatherLifeIndexes.setDetail(jSONObject2.optString("detail"));
                    weatherLifeIndexes.setName(jSONObject2.optString("name"));
                    weatherResult.getLifeIndexes().add(weatherLifeIndexes);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            WeatherResult weatherResult = new WeatherResult();
            if (str == null) {
                weatherResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return weatherResult;
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        weatherResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return weatherResult;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        char c = 65535;
                        int hashCode = optString.hashCode();
                        if (hashCode != -879828873) {
                            if (hashCode == 1470557208 && optString.equals("REQUEST_ERROR")) {
                                c = 1;
                            }
                        } else if (optString.equals("NETWORK_ERROR")) {
                            c = 0;
                        }
                        if (c != 0) {
                            if (c != 1) {
                                weatherResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            } else {
                                weatherResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                            }
                        } else {
                            weatherResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        }
                        return weatherResult;
                    }
                }
                if (!a(str, weatherResult, true)) {
                    a(jSONObject, weatherResult);
                }
                return weatherResult;
            }
            weatherResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return weatherResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetWeatherResultListener)) {
            ((OnGetWeatherResultListener) obj).onGetWeatherResultListener((WeatherResult) searchResult);
        }
    }
}
