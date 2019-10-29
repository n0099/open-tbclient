package com.baidu.live.j;

import com.baidu.live.adp.framework.controller.HttpRule;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a extends HttpRule {
    public a(int i) {
        super(i);
    }

    private void addSign(HttpMessage httpMessage) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        List<Map.Entry<String, Object>> encodeInBackGround = httpMessage.encodeInBackGround();
        for (int i = 0; encodeInBackGround != null && i < encodeInBackGround.size(); i++) {
            Map.Entry<String, Object> entry = encodeInBackGround.get(i);
            if (entry != null) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ((value instanceof String) && !"sign".equals(key)) {
                    stringBuffer.append(key + "=");
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append("tiebaclient!!!");
        httpMessage.addParam("sign", Md5.toMd5(stringBuffer.toString()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.controller.MessageRule
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessage != null && httpMessage.getCmd() < 1030999 && httpMessage.getCmd() >= 1021000) {
            httpMessage.addParam("cuid", TbadkCoreApplication.getUniqueIdentifier());
            addSign(httpMessage);
        }
        return httpMessage;
    }
}
