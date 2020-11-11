package com.baidu.network_service_plugin;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.data.Config;
import com.baidu.network_service_plugin.FlutterNetModelAuto;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseGetLivableForumList;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {
    private static HashMap<String, Integer> platformImageNameMap = new HashMap<>();

    static {
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + Config.GET_FORUM_LIST, 1001201);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + Config.M_SIGN, 0);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + Config.USER_INFO_ADDRESS, 1002700);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP, 0);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + TbConfig.GET_FORUM_DETAIL, 1002509);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS, 0);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS, 1002003);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + Config.EMOTION_FORUM_DETAIL, 1002510);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + TbConfig.DEBUG_UPLOAD, 0);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE, 1001506);
        platformImageNameMap.put(TbConfig.SERVER_ADDRESS + Config.FORUM_LIKE_ADDRESS, 1002002);
    }

    public static int js(String str) {
        if (platformImageNameMap.containsKey(str)) {
            return platformImageNameMap.get(str).intValue();
        }
        return 0;
    }

    public static h a(int i, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        return null;
    }

    public static TbSocketMessage e(int i, HashMap<String, Object> hashMap) {
        if (i == 104102) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setIsMask(Integer.valueOf((String) hashMap.get("isMask")).intValue());
            requestUpdateMaskInfoMessage.setMaskType(Integer.valueOf((String) hashMap.get("type")).intValue());
            requestUpdateMaskInfoMessage.setList((String) hashMap.get("list"));
            return requestUpdateMaskInfoMessage;
        } else if (i == 107129) {
            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
            requestGetLivableForumList.setGetLikeForum(1);
            requestGetLivableForumList.setPageNo(Integer.valueOf((String) hashMap.get("page_no")).intValue());
            requestGetLivableForumList.setPageSize(Integer.valueOf((String) hashMap.get("page_size")).intValue());
            requestGetLivableForumList.setUserId(Long.valueOf((String) hashMap.get("uid")).longValue());
            return requestGetLivableForumList;
        } else if (i == 304102) {
            RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
            requestDeleteFriendMessage.setFriendId(Long.valueOf((String) hashMap.get("uid")).longValue());
            return requestDeleteFriendMessage;
        } else {
            return null;
        }
    }

    public static FlutterNetModelAuto I(String str, int i) {
        FlutterNetModelAuto flutterNetModelAuto = new FlutterNetModelAuto(str, FlutterNetModelAuto.NetModelType.TYPE_SOCKET);
        flutterNetModelAuto.gJ(i);
        return flutterNetModelAuto;
    }

    public static FlutterNetModelAuto a(String str, int i, HashMap<String, Object> hashMap) {
        if (i == 104102) {
            FlutterNetModelAuto flutterNetModelAuto = new FlutterNetModelAuto(str, FlutterNetModelAuto.NetModelType.TYPE_SOCKET);
            flutterNetModelAuto.a(e(i, hashMap));
            flutterNetModelAuto.gK(i);
            flutterNetModelAuto.p(RequestUpdateMaskInfoMessage.class);
            flutterNetModelAuto.setResponseDataClass(ResponseUpdateMaskInfoMessage.class);
            return flutterNetModelAuto;
        } else if (i == 107129) {
            FlutterNetModelAuto flutterNetModelAuto2 = new FlutterNetModelAuto(str, FlutterNetModelAuto.NetModelType.TYPE_SOCKET);
            flutterNetModelAuto2.a(e(i, hashMap));
            flutterNetModelAuto2.setNeedCompress(false);
            flutterNetModelAuto2.dG(true);
            flutterNetModelAuto2.gK(i);
            flutterNetModelAuto2.p(RequestGetLivableForumList.class);
            flutterNetModelAuto2.setResponseDataClass(ResponseGetLivableForumList.class);
            return flutterNetModelAuto2;
        } else if (i == 304102) {
            FlutterNetModelAuto flutterNetModelAuto3 = new FlutterNetModelAuto(str, FlutterNetModelAuto.NetModelType.TYPE_SOCKET);
            flutterNetModelAuto3.a(e(i, hashMap));
            flutterNetModelAuto3.setNeedCompress(false);
            flutterNetModelAuto3.dG(true);
            flutterNetModelAuto3.gK(i);
            flutterNetModelAuto3.p(RequestDeleteFriendMessage.class);
            flutterNetModelAuto3.setResponseDataClass(ResponseDeleteFriendMessage.class);
            return flutterNetModelAuto3;
        } else {
            return null;
        }
    }

    public static Object d(SocketResponsedMessage socketResponsedMessage) {
        String str;
        int cmd = socketResponsedMessage.getCmd();
        if (cmd == 104102) {
            if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(BaseJsonData.TAG_ERRNO, responseUpdateMaskInfoMessage.getError());
                    jSONObject2.put(BaseJsonData.TAG_ERRMSG, responseUpdateMaskInfoMessage.getErrorString());
                    jSONObject2.put("errorInfo", jSONObject2);
                    str = jSONObject.toString();
                } catch (Exception e) {
                    BdLog.e(e);
                }
                return str;
            }
            str = null;
            return str;
        } else if (cmd == 107129) {
            if (socketResponsedMessage instanceof ResponseGetLivableForumList) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("has_more", responseGetLivableForumList.hasMore() ? 1 : 0);
                        JSONObject jSONObject4 = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        ArrayList<ForumData> data = responseGetLivableForumList.getData();
                        for (int i = 0; i < data.size(); i++) {
                            ForumData forumData = data.get(i);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("id", forumData.getId());
                            jSONObject5.put("name", forumData.getName());
                            jSONObject5.put("favo_type", forumData.getFavo_type());
                            jSONObject5.put("level_id", forumData.getUser_level());
                            jSONObject5.put("level_name", forumData.getLevelName());
                            jSONObject5.put("cur_score", forumData.getCurScore());
                            jSONObject5.put("levelup_score", forumData.getLevelupScore());
                            jSONObject5.put(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, forumData.getImage_url());
                            jSONObject5.put("slogan", forumData.getSlogan());
                            jSONArray.put(jSONObject5);
                        }
                        jSONObject4.put("non-gconforum", jSONArray);
                        jSONObject3.put("forum_list", jSONObject4);
                        return jSONObject3.toString();
                    } catch (Exception e2) {
                        BdLog.e(e2);
                        return null;
                    }
                }
                return null;
            }
            return null;
        } else if (cmd == 304102 && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            try {
                JSONObject jSONObject6 = new JSONObject();
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(BaseJsonData.TAG_ERRNO, responseDeleteFriendMessage.getError());
                jSONObject7.put(BaseJsonData.TAG_ERRMSG, responseDeleteFriendMessage.getErrorString());
                jSONObject7.put("errorInfo", jSONObject7);
                return jSONObject6.toString();
            } catch (Exception e3) {
                BdLog.e(e3);
                return null;
            }
        } else {
            return null;
        }
    }
}
