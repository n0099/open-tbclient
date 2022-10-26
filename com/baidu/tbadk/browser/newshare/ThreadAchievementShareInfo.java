package com.baidu.tbadk.browser.newshare;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class ThreadAchievementShareInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String desc;
    public String fr;
    public String img;
    public ParamBean params;
    public String title;

    /* loaded from: classes3.dex */
    public static class ContentBean implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String height;
        public String src;
        public String text;
        public int type;
        public String width;

        public ContentBean() {
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

        public String getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.height;
            }
            return (String) invokeV.objValue;
        }

        public String getSrc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.src;
            }
            return (String) invokeV.objValue;
        }

        public String getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.text;
            }
            return (String) invokeV.objValue;
        }

        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.type;
            }
            return invokeV.intValue;
        }

        public String getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.width;
            }
            return (String) invokeV.objValue;
        }

        public void setHeight(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.height = str;
            }
        }

        public void setSrc(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.src = str;
            }
        }

        public void setText(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.text = str;
            }
        }

        public void setType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.type = i;
            }
        }

        public void setWidth(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.width = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class ParamBean implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long agree_num;
        public List<ContentBean> content;
        public String date;
        public int interact;
        public String pageType;
        public long post_num;
        public int rank;
        public List<ThreadListBean> thread_list;
        public String thread_title;
        public String thread_type;
        public String tid;
        public String title;
        public String uid;
        public String url;
        public UserBean user;
        public VideoInfoBean video_info;

        public ParamBean() {
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

        public long getAgree_num() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.agree_num;
            }
            return invokeV.longValue;
        }

        public List<ContentBean> getContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.content;
            }
            return (List) invokeV.objValue;
        }

        public String getDate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.date;
            }
            return (String) invokeV.objValue;
        }

        public int getInteract() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.interact;
            }
            return invokeV.intValue;
        }

        public String getPageType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.pageType;
            }
            return (String) invokeV.objValue;
        }

        public long getPost_num() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.post_num;
            }
            return invokeV.longValue;
        }

        public int getRank() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.rank;
            }
            return invokeV.intValue;
        }

        public List<ThreadListBean> getThread_list() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.thread_list;
            }
            return (List) invokeV.objValue;
        }

        public String getThread_title() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.thread_title;
            }
            return (String) invokeV.objValue;
        }

        public String getThread_type() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.thread_type;
            }
            return (String) invokeV.objValue;
        }

        public String getTid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.tid;
            }
            return (String) invokeV.objValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public String getUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.uid;
            }
            return (String) invokeV.objValue;
        }

        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.url;
            }
            return (String) invokeV.objValue;
        }

        public UserBean getUser() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.user;
            }
            return (UserBean) invokeV.objValue;
        }

        public VideoInfoBean getVideo_info() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.video_info;
            }
            return (VideoInfoBean) invokeV.objValue;
        }

        public void setAgree_num(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
                this.agree_num = i;
            }
        }

        public void setContent(List<ContentBean> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
                this.content = list;
            }
        }

        public void setDate(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
                this.date = str;
            }
        }

        public void setInteract(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
                this.interact = i;
            }
        }

        public void setPageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
                this.pageType = str;
            }
        }

        public void setPost_num(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
                this.post_num = i;
            }
        }

        public void setRank(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
                this.rank = i;
            }
        }

        public void setThread_list(List<ThreadListBean> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
                this.thread_list = list;
            }
        }

        public void setThread_title(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
                this.thread_title = str;
            }
        }

        public void setThread_type(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
                this.thread_type = str;
            }
        }

        public void setTid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
                this.tid = str;
            }
        }

        public void setTitle(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
                this.title = str;
            }
        }

        public void setUid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
                this.uid = str;
            }
        }

        public void setUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
                this.url = str;
            }
        }

        public void setUser(UserBean userBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048606, this, userBean) == null) {
                this.user = userBean;
            }
        }

        public void setVideo_info(VideoInfoBean videoInfoBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048607, this, videoInfoBean) == null) {
                this.video_info = videoInfoBean;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                return "ParamBean{user=" + this.user + ", rank=" + this.rank + ", title='" + this.title + "', date='" + this.date + "', tid='" + this.tid + "', uid='" + this.uid + "', url='" + this.url + "', pageType='" + this.pageType + "', thread_list=" + this.thread_list + ", thread_type='" + this.thread_type + "', thread_title='" + this.thread_title + "', interact=" + this.interact + ", agree_num=" + this.agree_num + ", post_num=" + this.post_num + ", content=" + this.content + ", video_info=" + this.video_info + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class ThreadListBean implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int duration;
        public String hotvalue;
        public String img;
        public int index;
        public long tid;
        public String title;
        public String user_img;

        public ThreadListBean() {
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

        public int getDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.duration;
            }
            return invokeV.intValue;
        }

        public String getHotvalue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.hotvalue;
            }
            return (String) invokeV.objValue;
        }

        public String getImg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.img;
            }
            return (String) invokeV.objValue;
        }

        public int getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.index;
            }
            return invokeV.intValue;
        }

        public long getTid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.tid;
            }
            return invokeV.longValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public String getUser_img() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.user_img;
            }
            return (String) invokeV.objValue;
        }

        public void setDuration(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.duration = i;
            }
        }

        public void setHotvalue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.hotvalue = str;
            }
        }

        public void setImg(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.img = str;
            }
        }

        public void setIndex(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                this.index = i;
            }
        }

        public void setTid(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
                this.tid = j;
            }
        }

        public void setTitle(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.title = str;
            }
        }

        public void setUser_img(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                this.user_img = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class UserBean implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String img;
        public String user_img;
        public String username;

        public UserBean() {
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

        public String getImg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.img;
            }
            return (String) invokeV.objValue;
        }

        public String getUser_img() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.user_img;
            }
            return (String) invokeV.objValue;
        }

        public String getUsername() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.username;
            }
            return (String) invokeV.objValue;
        }

        public void setImg(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.img = str;
            }
        }

        public void setUser_img(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.user_img = str;
            }
        }

        public void setUsername(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.username = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class VideoDescBean implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int video_height;
        public int video_id;
        public int video_size;
        public String video_url;
        public int video_width;

        public VideoDescBean() {
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

        public int getVideo_height() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.video_height;
            }
            return invokeV.intValue;
        }

        public int getVideo_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.video_id;
            }
            return invokeV.intValue;
        }

        public int getVideo_size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.video_size;
            }
            return invokeV.intValue;
        }

        public String getVideo_url() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.video_url;
            }
            return (String) invokeV.objValue;
        }

        public int getVideo_width() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.video_width;
            }
            return invokeV.intValue;
        }

        public void setVideo_height(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.video_height = i;
            }
        }

        public void setVideo_id(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.video_id = i;
            }
        }

        public void setVideo_size(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.video_size = i;
            }
        }

        public void setVideo_url(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.video_url = str;
            }
        }

        public void setVideo_width(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.video_width = i;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class VideoDescCaeBean implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int video_height;
        public int video_id;
        public int video_size;
        public String video_url;
        public int video_width;

        public VideoDescCaeBean() {
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

        public int getVideo_height() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.video_height;
            }
            return invokeV.intValue;
        }

        public int getVideo_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.video_id;
            }
            return invokeV.intValue;
        }

        public int getVideo_size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.video_size;
            }
            return invokeV.intValue;
        }

        public String getVideo_url() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.video_url;
            }
            return (String) invokeV.objValue;
        }

        public int getVideo_width() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.video_width;
            }
            return invokeV.intValue;
        }

        public void setVideo_height(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.video_height = i;
            }
        }

        public void setVideo_id(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.video_id = i;
            }
        }

        public void setVideo_size(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.video_size = i;
            }
        }

        public void setVideo_url(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.video_url = str;
            }
        }

        public void setVideo_width(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.video_width = i;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class VideoDescH265Bean implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int video_height;
        public int video_id;
        public int video_size;
        public String video_url;
        public int video_width;

        public VideoDescH265Bean() {
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

        public int getVideo_height() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.video_height;
            }
            return invokeV.intValue;
        }

        public int getVideo_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.video_id;
            }
            return invokeV.intValue;
        }

        public int getVideo_size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.video_size;
            }
            return invokeV.intValue;
        }

        public String getVideo_url() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.video_url;
            }
            return (String) invokeV.objValue;
        }

        public int getVideo_width() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.video_width;
            }
            return invokeV.intValue;
        }

        public void setVideo_height(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.video_height = i;
            }
        }

        public void setVideo_id(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.video_id = i;
            }
        }

        public void setVideo_size(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.video_size = i;
            }
        }

        public void setVideo_url(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.video_url = str;
            }
        }

        public void setVideo_width(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.video_width = i;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class VideoInfoBean implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int auditing;
        public int format_matched;
        public String origin_video_url;
        public String thumbnail_height;
        public String thumbnail_url;
        public String thumbnail_width;
        public int version_h265;
        public List<VideoDescBean> video_desc;
        public List<VideoDescCaeBean> video_desc_cae;
        public List<VideoDescH265Bean> video_desc_h265;
        public String video_duration;
        public String video_height;
        public String video_length;
        public long video_log_id;
        public String video_md5;
        public String video_type;
        public String video_url;
        public String video_width;

        public VideoInfoBean() {
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

        public int getAuditing() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.auditing;
            }
            return invokeV.intValue;
        }

        public int getFormat_matched() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.format_matched;
            }
            return invokeV.intValue;
        }

        public String getOrigin_video_url() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.origin_video_url;
            }
            return (String) invokeV.objValue;
        }

        public String getThumbnail_height() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.thumbnail_height;
            }
            return (String) invokeV.objValue;
        }

        public String getThumbnail_url() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.thumbnail_url;
            }
            return (String) invokeV.objValue;
        }

        public String getThumbnail_width() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.thumbnail_width;
            }
            return (String) invokeV.objValue;
        }

        public int getVersion_h265() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.version_h265;
            }
            return invokeV.intValue;
        }

        public List<VideoDescBean> getVideo_desc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.video_desc;
            }
            return (List) invokeV.objValue;
        }

        public List<VideoDescCaeBean> getVideo_desc_cae() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.video_desc_cae;
            }
            return (List) invokeV.objValue;
        }

        public List<VideoDescH265Bean> getVideo_desc_h265() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.video_desc_h265;
            }
            return (List) invokeV.objValue;
        }

        public String getVideo_duration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.video_duration;
            }
            return (String) invokeV.objValue;
        }

        public String getVideo_height() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.video_height;
            }
            return (String) invokeV.objValue;
        }

        public String getVideo_length() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.video_length;
            }
            return (String) invokeV.objValue;
        }

        public long getVideo_log_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.video_log_id;
            }
            return invokeV.longValue;
        }

        public String getVideo_md5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.video_md5;
            }
            return (String) invokeV.objValue;
        }

        public String getVideo_type() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.video_type;
            }
            return (String) invokeV.objValue;
        }

        public String getVideo_url() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.video_url;
            }
            return (String) invokeV.objValue;
        }

        public String getVideo_width() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.video_width;
            }
            return (String) invokeV.objValue;
        }

        public void setAuditing(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
                this.auditing = i;
            }
        }

        public void setFormat_matched(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
                this.format_matched = i;
            }
        }

        public void setOrigin_video_url(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
                this.origin_video_url = str;
            }
        }

        public void setThumbnail_height(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
                this.thumbnail_height = str;
            }
        }

        public void setThumbnail_url(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
                this.thumbnail_url = str;
            }
        }

        public void setThumbnail_width(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
                this.thumbnail_width = str;
            }
        }

        public void setVersion_h265(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
                this.version_h265 = i;
            }
        }

        public void setVideo_desc(List<VideoDescBean> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
                this.video_desc = list;
            }
        }

        public void setVideo_desc_cae(List<VideoDescCaeBean> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
                this.video_desc_cae = list;
            }
        }

        public void setVideo_desc_h265(List<VideoDescH265Bean> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
                this.video_desc_h265 = list;
            }
        }

        public void setVideo_duration(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
                this.video_duration = str;
            }
        }

        public void setVideo_height(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
                this.video_height = str;
            }
        }

        public void setVideo_length(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
                this.video_length = str;
            }
        }

        public void setVideo_log_id(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
                this.video_log_id = j;
            }
        }

        public void setVideo_md5(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
                this.video_md5 = str;
            }
        }

        public void setVideo_type(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
                this.video_type = str;
            }
        }

        public void setVideo_url(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
                this.video_url = str;
            }
        }

        public void setVideo_width(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
                this.video_width = str;
            }
        }
    }

    public ThreadAchievementShareInfo() {
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

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.desc;
        }
        return (String) invokeV.objValue;
    }

    public String getFr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.fr;
        }
        return (String) invokeV.objValue;
    }

    public String getImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.img;
        }
        return (String) invokeV.objValue;
    }

    public ParamBean getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.params;
        }
        return (ParamBean) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public void setDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.desc = str;
        }
    }

    public void setFr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.fr = str;
        }
    }

    public void setImg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.img = str;
        }
    }

    public void setParams(ParamBean paramBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, paramBean) == null) {
            this.params = paramBean;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.title = str;
        }
    }
}
