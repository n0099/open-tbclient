package com.baidu.searchbox.abtest;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.abtest.ioc.ICSPDataService;
@Singleton
@Service
/* loaded from: classes3.dex */
public class ABTestClientSampleImpl implements ICSPDataService {
    @Override // com.baidu.searchbox.abtest.ioc.ICSPDataService
    public String config() {
        return "{\"sample\":{\"mGwcm\":{\"56250_1\":[[0,15]],\"56250_2\":[[15,24],[64,70]],\"55615_1\":[[34,44]],\"55615_2\":[[44,54]],\"55615_3\":[[54,64]],\"55614_1\":[[24,29]],\"55614_2\":[[29,34]],\"55613_1\":[[0,2]],\"55613_2\":[[2,4]],\"55612_1\":[[4,14]],\"55612_2\":[[14,24]]},\"1ztan\":{\"56242_1\":[[0,50]],\"56242_2\":[[50,100]]}},\"mapping\":{\"56250_1\":[{\"key\":\"rise_newactive_retain\",\"data\":0}],\"56250_2\":[{\"key\":\"rise_newactive_retain\",\"data\":1}],\"56242_1\":[{\"key\":\"feed_new_active_user_attributes\",\"data\":false}],\"56242_2\":[{\"key\":\"feed_new_active_user_attributes\",\"data\":true}],\"55615_1\":[{\"key\":\"rise_visitor_mode_android\",\"data\":6}],\"55615_2\":[{\"key\":\"rise_visitor_mode_android\",\"data\":7}],\"55615_3\":[{\"key\":\"rise_visitor_mode_android\",\"data\":8}],\"55614_1\":[{\"key\":\"rise_visitor_mode_android\",\"data\":4}],\"55614_2\":[{\"key\":\"rise_visitor_mode_android\",\"data\":5}],\"55613_1\":[{\"key\":\"rise_down_cuidtoast_android\",\"data\":0}],\"55613_2\":[{\"key\":\"rise_down_cuidtoast_android\",\"data\":1}],\"55612_1\":[{\"key\":\"rise_down_guide_toast_android\",\"data\":2}],\"55612_2\":[{\"key\":\"rise_down_guide_toast_android\",\"data\":3}]},\"beginVersion\":\"13.31.0.0\",\"endVersion\":\"13.31.0.10\",\"kvVersion\":\"fa2131c5171a54d4e6ca27d38fd0bcdf\"}";
    }
}
